package com.marcos.mcp.lab_padroes_projeto_spring.service.implementations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Endereco;
import com.marcos.mcp.lab_padroes_projeto_spring.service.ViaCepService;

@Service
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public class ViaCepServiceImpl implements ViaCepService {
    
    @Override
    @GetMapping("/{cep}/json/")
    public Endereco consultarCep(String cep) {
        // Implementação do método para consultar o CEP usando a API do ViaCEP
        // Você pode usar RestTemplate ou WebClient para fazer a chamada HTTP
        // e retornar o endereço correspondente ao CEP fornecido.
        return null; // Retorne o endereço obtido da API
    }
    
}
