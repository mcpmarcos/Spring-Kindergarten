package com.marcos.mcp.lab_padroes_projeto_spring.service;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Client;

public interface ClientService {
    
    Iterable<Client> findAll();

    Client findById(Long id);

    void create(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
