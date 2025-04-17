package com.mcp.springdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mcp.springdatajpa.model.User;
import com.mcp.springdatajpa.repositoryh.UserRepository;

@Component
public class StartApp implements CommandLineRunner{
    
    @Autowired
    UserRepository repository;

    
    @Override
    public void run(String... args) throws Exception {
        //inserirUser();
        List<User> users = repository.filtrarPorNome("José");
        for (User u : users) {
            System.out.println(u);
        }
    }
    
    public void inserirUser(){
        
        User aluno = new User();
        aluno.setName("José Torres");
        aluno.setUsername("Diogenes");
        aluno.setPassword("dio123");
        
        User aluno2 = new User();
        aluno2.setName("Gabriel");
        aluno2.setUsername("Damasceno");
        aluno2.setPassword("dio321");
        
        repository.save(aluno);
        repository.save(aluno2);
        
        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }
}
