package com.mcp.springdatajpa.repositoryh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mcp.springdatajpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer >{
    

    // Query Method
    List<User> findByNameContaining(String name);
    
    // Query Method(precisa respeitar o casesensitive igual ao nome da variável declarada)
    User findByUsername(String username);

    // Query Override
    @Query("SELECT u from User u WHERE u.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name")String name);    


}
