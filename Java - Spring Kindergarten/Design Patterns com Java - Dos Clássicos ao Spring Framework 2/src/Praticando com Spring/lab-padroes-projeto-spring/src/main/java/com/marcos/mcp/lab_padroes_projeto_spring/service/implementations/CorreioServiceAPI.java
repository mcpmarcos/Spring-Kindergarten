package com.marcos.mcp.lab_padroes_projeto_spring.service.implementations;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Endereco;

public class CorreioServiceAPI {
    
    
    public Endereco getDadosLocalizacao(String city){
        // Lógica para acessar a API do Correio e obter os dados de localização com base no nome da pessoa
        // Retorna um objeto Endereco com os dados de localização
        return new Endereco("BA", "Salvador", "Rua do Sossego - 111");
    }
}
