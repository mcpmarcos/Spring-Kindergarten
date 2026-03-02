import java.util.function.UnaryOperator;

public class OperadorUnario {
    
    public static void main(String[] args) {
        
        // Operador Unário

        // O operador unário é um tipo de operador que atua sobre um único operando para realizar uma operação. Ele pode ser usado para modificar o valor do operando ou para realizar uma ação específica. Alguns exemplos comuns de operadores unários incluem:

        // Incremento (++) e Decremento (--): Esses operadores aumentam ou diminuem o valor de uma variável em 1, respectivamente. Por exemplo, se x for igual a 5, x++ resultará em 6, enquanto x-- resultará em 4.

        UnaryOperator<Integer> addTwo = n -> n + 2;
        UnaryOperator<Integer> multiplyByTwo = n -> n * 2;
        UnaryOperator<Integer> square = n -> n * n;

        int result1 = addTwo.andThen(multiplyByTwo).andThen(square).apply(0);

        // compose 
        
        // O método compose() um método default da interface UnaryOperator que permite encadear operações de forma inversa. Ele recebe outra função como argumento e retorna uma nova função que, quando aplicada, executa a função fornecida como argumento primeiro e depois a função original. Isso é útil para criar pipelines de transformação de dados de forma mais legível e concisa, especialmente quando a ordem das operações é importante.


        int result2 = square.compose(multiplyByTwo).compose(addTwo).apply(0);

        System.out.println(addTwo.apply(5)); // Saída: 7
        
        System.out.println(result1);

        System.out.println(result2);



    }
}
