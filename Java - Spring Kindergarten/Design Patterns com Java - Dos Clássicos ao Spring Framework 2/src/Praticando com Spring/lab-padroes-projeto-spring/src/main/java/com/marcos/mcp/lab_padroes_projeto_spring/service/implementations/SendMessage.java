package com.marcos.mcp.lab_padroes_projeto_spring.service.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.marcos.mcp.lab_padroes_projeto_spring.model.Message;

public class SendMessage {
    private List<Message> msg = new ArrayList<>(); 

    public void addMessage(Message message){
        this.msg.add(message);
    }

    public List<Message> getMsg() {
        return Collections.unmodifiableList(this.msg);
    }
}
