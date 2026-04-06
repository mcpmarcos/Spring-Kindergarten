package com.marcos.mcp.lab_padroes_projeto_spring.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Endereco;

// @FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    

    // @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    
    // @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
