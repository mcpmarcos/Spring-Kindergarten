package com.marcos.mcp.lab_padroes_projeto_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Client;
import com.marcos.mcp.lab_padroes_projeto_spring.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){
        clientService.create(client);
        return ResponseEntity.ok(client);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id,@RequestBody Client client){
        clientService.update(id, client);
        return ResponseEntity.ok(clientService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("API is working!");
    }
}
