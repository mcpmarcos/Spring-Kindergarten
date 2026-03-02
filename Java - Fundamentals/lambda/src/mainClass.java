public class mainClass {
    public static void main(String[] args) {
        
        ICalculo calculo = new Somar();
        System.out.println("Soma: " + calculo.executar(5, 3));
        
        
        calculo = new Multiplicar();
        System.out.println("Multiplicação: " + calculo.executar(5, 3));

    }
}