package Subsystem02;

public class CepApi {
    
    private static CepApi instancia = new CepApi();

    private CepApi() {
        super();
        // Construtor privado para evitar instanciamento externo
    }

    public static CepApi getInstancia() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        // Lógica para recuperar a cidade com base no CEP
        return "Cidade Exemplo";
    }

    public String recuperarEstado(String cep) {
        // Lógica para recuperar o estado com base no CEP
        return "Estado Exemplo";
    }
}
