import java.util.function.BinaryOperator;

public class CalculoTeste2 {
     public static void main(String[] args) {
        
        
        BinaryOperator<Double> calc = (x, y) -> { return x + y;};
        System.err.println(calc.apply(2.8, 3.4));
        
        // calc = (x, y) -> {return x * y;};
        calc = (x, y) -> x * y ;
        System.err.println(calc.apply(2.8, 3.4));
        
        BinaryOperator<Integer> call = (x, y) -> { return x + y;};
        System.err.println(call.apply(8, 3));
        
    }
}
