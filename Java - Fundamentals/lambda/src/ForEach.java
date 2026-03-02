import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        
    List<String> aproved = Arrays.asList("anna", "Bia", "Lia", "Gui");

    System.out.println("\nForma tradicional: ");
    for (String name : aproved) {
        System.out.println(name);
    }

    System.out.println();

    System.out.println("Lambda #1: \n");
    aproved.forEach((nome) -> {System.out.println(nome + " !!!");});
    
    System.out.println();

    // Caso eu tenha apenas um parâmetro para ser utilizado na lambda expressio, posso eliminar os parênteses dele
    aproved.forEach(nome -> {System.out.println(nome + " !!!");});
    
    System.out.println();
    
    System.out.println("Lambda #2: \n");
    
    // Caso eu tenha apenas uma sentença de código para ser utilizado na lambda expression, posso eliminar os parênteses dele, além disso eu posso eliminar o ";" após o parêntesis do foreach 
    aproved.forEach(nome -> System.out.println(nome + " !!!"));
    
    System.out.println();   
    System.out.println("Lambda #3: ");
    
    
    System.out.println("\nMethod Reference...");
    aproved.forEach(System.out::println);
    
    System.out.println();   
    System.out.println("Lambda #4: ");
    
    
    System.out.println("\nMethod Reference 2 ...");
    aproved.forEach(ForEach::meuImprimir);

}


static void meuImprimir(String nome){
        System.out.println(nome);   
    }


    
}
