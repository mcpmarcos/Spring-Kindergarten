import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {
    
    public static void main(String[] args) {
        
        Supplier<List<String>> supplierList = () -> Arrays.asList("Ana", "Bob", "Gui");

        System.out.println(supplierList.get());
        supplierList.get().forEach(System.out::println);
    }
}
