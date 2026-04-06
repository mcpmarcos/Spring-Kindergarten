package com.marcos.mcp.lab_padroes_projeto_spring.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Client;
import com.marcos.mcp.lab_padroes_projeto_spring.repository.ClientRepository;
import com.marcos.mcp.lab_padroes_projeto_spring.repository.EnderecoRepository;
import com.marcos.mcp.lab_padroes_projeto_spring.service.ClientService;
import com.marcos.mcp.lab_padroes_projeto_spring.service.ViaCepService;

@Service
public class ClientServiceImp implements ClientService{
    
    // Singleton: Injetar os componentes do spring com @Autowired
    // Strategy: Implementar os métodos definidos na interface
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        
        // Para simplificar, estamos retornando o cliente diretamente. Em um cenário real, seria necessário tratar o caso de cliente não encontrado.
        
        Optional<Client> client = clientRepository.findById(id); 
        
        return client.get(); 
        
    }

    @Override
    public void create(Client client) {
    
        // Verificar se o Endereço do cliente já existe (pelo CEP).
        
        String cep = client.getEndereco().getCep();
        enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            
            return null;
        }); // Como o o findBy retorna um optional, podemos usar o orElseGet para retornar null caso o endereço não exista.
    

        // Inserir cliente, vinculando o endereço (novo ou existente)
    }

    @Override
    public void update(Long id, Client client) {
        // Buscar cliente opor ID, caso exista
        // Verificar se o Endereço do cliente já existe (pelo CEP).
        // Caso não exista, integrar com o ViaCEP e persistir o retorno.
        // Alterar cliente, vinculando o endereço (novo ou existente)
    }

    @Override
    public void delete(Long id) {
        // Deletar cliente por ID
    }

}
