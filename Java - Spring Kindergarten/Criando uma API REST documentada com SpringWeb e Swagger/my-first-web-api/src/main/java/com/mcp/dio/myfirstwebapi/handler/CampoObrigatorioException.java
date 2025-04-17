package com.mcp.dio.myfirstwebapi.handler;

public class CampoObrigatorioException extends BusinessException {
    
    public CampoObrigatorioException(String campo){
        super("O %s é obrigatório!!", campo);
    }

}
