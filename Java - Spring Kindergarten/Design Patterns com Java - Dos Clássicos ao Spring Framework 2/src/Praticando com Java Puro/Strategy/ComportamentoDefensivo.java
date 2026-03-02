package Strategy;

public class ComportamentoDefensivo implements IComportamento{
    
    @Override
    public void mover() {
        System.out.println("Movendo-se de forma defensiva...");
    }
}
