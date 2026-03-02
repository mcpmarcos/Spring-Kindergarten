import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
    
    public static void main(String[] args) {
        
        // BinaryOperator<T> é uma interface funcional que representa uma operação binária sobre um tipo específico. Ela é parte do pacote java.util.function e possui um método abstrato chamado apply(T t1, T t2) que recebe dois argumentos do mesmo tipo e retorna um resultado do mesmo tipo.


        //===================================================================

        BinaryOperator<Double> media = (x, y) -> (x + y) / 2;
        System.out.println(media.apply(2.8, 3.4));

        // BiFunction<T, U, R> é uma interface funcional que representa uma função que recebe dois argumentos de tipos diferentes e retorna um resultado. Ela é parte do pacote java.util.function e possui um método abstrato chamado apply(T t, U u) que recebe dois argumentos e retorna um resultado.

        BiFunction<Double, Double, String> result = ((n1, n2) -> {
            double mediaResult = (n1 + n2) / 2;
            return mediaResult >= 7 ? "Aprovado" : "Reprovado";
        });

        BiFunction<Double, Double, String> result2 = ((n1, n2) -> (n1 + n2) / 2 >= 5 ? "Aprovado" : "Reprovado");

        System.out.println(result.apply(2.8, 3.4));
    
        System.out.println(result2.apply(7.8, 4.4));

        //===================================================================

        Function<Double, String> conceito = m -> m >= 6 ? "Aprovado" : "Reprovado";

        System.out.println(conceito.apply(media.apply(6.0, 6.0)));

        System.out.println(media.andThen(conceito).apply(5.0, 7.0));
        
    }

}
