import java.util.function.Predicate;

public class Predicado {
    
    public static void main(String[] args) {
        
        // Predicate<Produto> isExpensive = prod -> prod.preco <= 750.0;
    
        Predicate<Produto> isExpensive = prod -> prod.preco * (1 - prod.desconto)>= 750.0;

        System.out.println(isExpensive.test(
            new Produto(
                "Notebook", 
                2500.0, 
                0.75)
        ));
    }


}

/*

Predicates são interfaces funcionais que representam uma função que recebe um argumento e retorna um valor booleano. Eles são frequentemente usados para expressar condições ou critérios de filtragem em coleções de dados. A interface Predicate<T> é parte do pacote java.util.function e possui um método abstrato chamado test(T t) que avalia a condição definida pelo predicado.

*/