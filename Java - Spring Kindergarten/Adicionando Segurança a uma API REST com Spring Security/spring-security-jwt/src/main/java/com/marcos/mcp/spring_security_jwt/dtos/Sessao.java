package com.marcos.mcp.spring_security_jwt.dtos;

public class Sessao {
    private String token;
    private String login;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
