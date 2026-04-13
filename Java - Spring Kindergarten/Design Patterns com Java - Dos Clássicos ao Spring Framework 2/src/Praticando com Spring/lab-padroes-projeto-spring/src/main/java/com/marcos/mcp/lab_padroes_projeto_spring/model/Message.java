package com.marcos.mcp.lab_padroes_projeto_spring.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Message {
   
    private String id;
    private String message;

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
