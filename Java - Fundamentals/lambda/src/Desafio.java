import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
    
    public static void main(String[] args) {
        
        
        /*
        
        1 A partir do produto, calcular o preço com desconto (preço * (1 - desconto)).
        2 Imposto municipal: >= 2500 (8.5%) / < 2500 (Isento)
        3 Frete: >= 3000 (100) / < 3000 (50)
        4 Arredondar: Deixar 2 casas decimais.
        5 Formatação: R$1234,56
        
        */
       
       Function<Produto, Double> precoFinal = prod -> prod.getPreco() * (1 - prod.getDesconto());
       UnaryOperator<Double> impostoMunicipal = price -> price >= 2500 ? price * 1.085 : price;
       UnaryOperator<Double> frete = price -> price >= 3000 ? price + 100 : price + 50;
       UnaryOperator<Double> arredondar = price -> Double.parseDouble(String.format("%.2f", price)); // Não funciona
       Function<Double, String> formatar = price -> ("R$" + price).replace(".", ",");
       
       Produto p = new Produto("iPad", 3500.0, 0.75);
       
       String preco = precoFinal
        .andThen(impostoMunicipal)
        .andThen(frete)
        // .andThen(arredondar)
        .andThen(formatar)
        .apply(p);
        
       System.out.println(preco);



      
    }
}
