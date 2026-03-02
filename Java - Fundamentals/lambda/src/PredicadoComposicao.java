import java.util.function.Predicate;

public class PredicadoComposicao {
    
    public static void main(String[] args) {
        

        Predicate<Integer> isPar = num -> num % 2 == 0;

        Predicate<Integer> isThreeDigits = num -> num >= 100 && num <= 999;

        System.out.println();

        System.out.println("========================================================");
        

        System.out.println(isPar.test(2));
        
        System.out.println(isThreeDigits.test(2));
        
        System.out.println();

        System.out.println("========================================================");

        //=======================================================
        
        // Como a interfacePredicate retorna um boolean, ela possui métodos default para composição lógica, como and(), or() e negate(). Esses métodos permitem combinar múltiplos predicados para criar condições mais complexas de forma concisa e legível.

        System.out.println(isPar.and(isThreeDigits).test(201));

        System.out.println(isPar.or(isThreeDigits).test(201));

        System.out.println(isPar.and(isThreeDigits).negate().test(201));

        System.out.println();

        System.out.println("========================================================");
        

    }
}
