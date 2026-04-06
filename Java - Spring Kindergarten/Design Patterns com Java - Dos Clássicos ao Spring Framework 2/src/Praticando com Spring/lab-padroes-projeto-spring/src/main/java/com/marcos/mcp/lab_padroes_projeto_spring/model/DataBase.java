package com.marcos.mcp.lab_padroes_projeto_spring.model;

import java.util.logging.Logger;

public class DataBase {
    
    private static final Logger LOGGER = Logger.getLogger(DataBase.class.getName()); 

    public static void startConection(){

        // Lógica para iniciar a conexão com o banco de dados
        LOGGER.info("Conexão com o banco de dados iniciada.");
    }
    
    public static void stopConection(){

        // Lógica para encerrar a conexão com o banco de dados
        LOGGER.info("Conexão com o banco de dados encerrada.");
    }

    public static void insertPersonOnDatabase(Person p){
        // Lógica para inserir uma pessoa no banco de dados
        LOGGER.info("Pessoa inserida no banco de dados.");
    }
 
    public static void removePersonOnDatabase(Person p){
        // Lógica para remover uma pessoa do banco de dados
        LOGGER.info("Pessoa removida do banco de dados.");
    }
}
