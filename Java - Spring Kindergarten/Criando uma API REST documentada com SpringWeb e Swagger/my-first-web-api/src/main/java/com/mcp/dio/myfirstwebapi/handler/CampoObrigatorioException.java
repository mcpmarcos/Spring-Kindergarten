package com.mcp.dio.myfirstwebapi.handler;

public class CampoObrigatorioException extends RuntimeException  {
    
    public CampoObrigatorioException(String mensagem) {
		super(mensagem);
	}
	public CampoObrigatorioException(String mensagem, Object ... params) {
		super(String.format(mensagem, params));
	}
}
