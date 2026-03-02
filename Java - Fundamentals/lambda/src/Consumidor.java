
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

    
    public static void main(String[] args) {
        
        // Consumer é uma interface funcional que representa uma operação que aceita um único argumento de entrada e não retorna nenhum resultado. Ele é frequentemente usado para realizar ações ou efeitos colaterais em objetos, como imprimir valores, modificar estados ou executar tarefas específicas. A interface Consumer<T> é parte do pacote java.util.function e possui um método abstrato chamado accept(T t) que executa a operação definida pelo consumidor.

        // ======================================================

        // Consumer<String> imprimir = mensagem -> System.out.println(mensagem);
        
        // imprimir.accept("Olá, mundo!");
        
        
        // ======================================================
        
        Consumer<Produto> imprimir = p -> System.out.println(p.nome + " custa " + p.preco);
        
        Produto p1 = new Produto("Notebook", 2500.0, 0.75);
        
        System.out.println();
        
        imprimir.accept(p1);

        Produto p2 = new Produto("Smartphone", 1500.0, 0.1);
        Produto p3 = new Produto("Tablet", 800.0, 0.2);
        Produto p4 = new Produto("Monitor", 1200.0, 0.15);
        Produto p5 = new Produto("Impressora", 300.0, 0.05);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
        
        produtos.forEach(imprimir);
        
        System.out.println();

        produtos.forEach(p -> System.out.println(" custa " + p.preco));
        
        System.out.println();
        
        produtos.forEach(System.out::println); // Neste caso aqui, é necessário queo objeto tenha implementado o método toString() para que a exibição seja feita de forma adequada, caso contrário, será exibido o nome da classe seguido do hashcode do objeto.

        // ======================================================
        
        Consumer<Produto> printProduct = prod -> System.out.println("Produto: " + prod.nome + ", Preço: " + prod.preco);
        
        System.out.println();

        printProduct.accept(new Produto("Wolf Limited", 1500.0, 0.1)); 
        
        System.out.println();
        
        // ======================================================

        

    }
}
