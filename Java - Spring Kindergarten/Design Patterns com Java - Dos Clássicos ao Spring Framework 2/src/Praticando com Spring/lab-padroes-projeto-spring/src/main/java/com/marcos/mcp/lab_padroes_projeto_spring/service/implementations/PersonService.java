package com.marcos.mcp.lab_padroes_projeto_spring.service.implementations;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Endereco;
import com.marcos.mcp.lab_padroes_projeto_spring.model.Person;

public class PersonService {
    
    private CorreioServiceAPI correioServiceAPI;

    public PersonService(CorreioServiceAPI correioServiceAPI) {
        this.correioServiceAPI = correioServiceAPI;
    }

    public Person personRegister (String name, int age){

        Person person = new Person(name, age);

        Endereco dadosLocalizacao = correioServiceAPI.getDadosLocalizacao("Salvador");

        person.setEndereco(dadosLocalizacao);

        return person;
    }
}
