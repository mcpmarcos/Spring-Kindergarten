package com.marcos.mcp.spring_security_jwt.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

public class JWTCreator {
    
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

 
    // A solução foi utilizar uma estratégia de array de bytes
    public static String create(String prefix, String key, JWTObject jwtObject) {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);
        String token = Jwts.builder()
            .setSubject(jwtObject.getSubject())
            .setIssuedAt(jwtObject.getIssuedAt())
            .setExpiration(jwtObject.getExpiration())
            .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact();
            return prefix + " " + token;
    }

    public static JWTObject create(String token,String prefix,String key)
        throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        JWTObject object = new JWTObject();
        token = token.replace(prefix, "").trim();
        byte[] keyBytes = Base64.getDecoder().decode(key);
        SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);
        Claims claims = Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody();
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        object.setRoles((List) claims.get(ROLES_AUTHORITIES));
        return object;
    }

    private static List<String> checkRoles(List<String> roles) {
        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_",""))).collect(Collectors.toList());
    }

     // Estes dois métodos acabaram não sendo utilizados por mim graças a um erro que ocorreu por conta de um caracter " _ " que não é aceito na base64

    // public static String create(String prefix,String key, JWTObject jwtObject) {
    //     String token = Jwts.builder().setSubject(jwtObject.getSubject()).setIssuedAt(jwtObject.getIssuedAt()).setExpiration(jwtObject.getExpiration())
    //             .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles())).signWith(SignatureAlgorithm.HS512, key).compact();
    //     return prefix + " " + token;
    // }

    //=========================================================
    
    // public static JWTObject create(String token,String prefix,String key)
    //         throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        //     JWTObject object = new JWTObject();
        //     token = token.replace(prefix, "");
        //     Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        //     object.setSubject(claims.getSubject());
        //     object.setExpiration(claims.getExpiration());
        //     object.setIssuedAt(claims.getIssuedAt());
        //     object.setRoles((List) claims.get(ROLES_AUTHORITIES));
        //     return object;
        
        // }
        
        //=========================================================


}
