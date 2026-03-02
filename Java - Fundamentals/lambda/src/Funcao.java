import java.util.function.Function;

public class Funcao {
    
    public static void main(String[] args) {
        
        // Função

        // Função é uma interface funcional que representa uma função que recebe um argumento e retorna um resultado. Ela é frequentemente usada para expressar transformações ou mapeamentos em coleções de dados. A interface Function<T, R> é parte do pacote java.util.function e possui um método abstrato chamado apply(T t) que executa a função definida pelo usuário.

        Function<Double, String> half = a -> "A metade de " + a + " é " + (a / 2);

        Function<Double, String> parOuImpar = a ->  (a % 2 == 0) ? "Par" : "Impar";

        Function<String, String> showResult = value -> "Resultado: O valor é " + value;
        
        Function<String, String> toEmpolgado = value -> value + " !!!";

        Function<String, String> toComDuvida = value -> value + " ???";
        
        System.out.println(half.apply(10.0));

        System.out.println();
        
        System.out.println(parOuImpar.apply(15.0));
        
        System.out.println();

        System.out.println(showResult.apply(parOuImpar.apply(15.0)));

        // Outra opção é:

        String result = parOuImpar.andThen(showResult).apply(15.0);
        
        System.out.println(result);
        
        // o método andThen() é um método default da interface Function que permite encadear funções. Ele recebe outra função como argumento e retorna uma nova função que, quando aplicada, executa a função original e depois a função fornecida como argumento. Isso é útil para criar pipelines de transformação de dados de forma mais legível e concisa. Estemétodo pode ser concatenado com si mesmo quantas vezes for necessário, permitindo a construção de cadeias complexas de operações em uma única expressão.
        

        String resultadoComEmocao = parOuImpar.andThen(showResult).andThen(toEmpolgado).apply(15.0);
    
        System.out.println(resultadoComEmocao);
        
        String resultadoComDuvida = parOuImpar.andThen(showResult).andThen(toComDuvida).apply(15.0);
    
        System.out.println(resultadoComDuvida);
    }
}
