package com.marcos.mcp.spring_security_jwt.controlller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.mcp.spring_security_jwt.dtos.Login;
import com.marcos.mcp.spring_security_jwt.dtos.Sessao;
import com.marcos.mcp.spring_security_jwt.model.User;
import com.marcos.mcp.spring_security_jwt.repository.UserRepository;
import com.marcos.mcp.spring_security_jwt.security.JWTCreator;
import com.marcos.mcp.spring_security_jwt.security.JWTObject;
import com.marcos.mcp.spring_security_jwt.security.SecurityConfig;

@RestController
public class LoginController {
    
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;
    
    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login ){
        
        User user = repository.findByUsername(login.getUsername());
    
        if (user!=null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
    
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
    
            Sessao sessao = new Sessao();
    
            sessao.setLogin(login.getUsername());
    
            JWTObject jwtobject = new JWTObject();
            
            jwtobject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtobject.setExpiration(new Date(System.currentTimeMillis() + securityConfig.getExpiration()));
            jwtobject.setRoles(user.getRoles());
    
            sessao.setToken(JWTCreator.create(securityConfig.getPrefix(), securityConfig.getKey(), jwtobject));
            
            return sessao;
        } else{
            throw new RuntimeException("Erro ao tentar logar");
        }
    } 



    // Versão anterior(original do tutorial) abaixo:

    // @PostMapping("/login")
    // public Sessao logar(@RequestBody Login login ){
        
    //     User user = repository.findByUsername(login.getUsername());
    
    //     if (user!=null) {
    //         boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
    
    //         if (!passwordOk) {
    //             throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
    //         }
    
    //         Sessao sessao = new Sessao();
    
    //         sessao.setLogin(login.getUsername());
    
    //         JWTObject jwtobject = new JWTObject();
            
    //         jwtobject.setIssuedAt(new Date(System.currentTimeMillis()));
    //         jwtobject.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
    //         jwtobject.setRoles(user.getRoles());
    
    //         sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtobject));
            
    //         return sessao;
    //     } else{
    //         throw new RuntimeException("Erro ao tentar logar");
    //     }
    // } 

}
