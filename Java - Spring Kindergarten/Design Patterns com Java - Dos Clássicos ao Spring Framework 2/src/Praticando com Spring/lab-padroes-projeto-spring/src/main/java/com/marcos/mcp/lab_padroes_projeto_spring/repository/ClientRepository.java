package com.marcos.mcp.lab_padroes_projeto_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    


}
