import Strategy.ComportamentoAgressivo;
import Strategy.ComportamentoDefensivo;
import Strategy.ComportamentoNormal;
import Strategy.Robo;

public class TestStrategy {
    

    // Classe CLIENT
     
    public static void main(String[] args) {
    
        Robo robo = new Robo();
    
        robo.setStrategy(new ComportamentoNormal());
    
        robo.mover();
    
        robo.setStrategy(new ComportamentoDefensivo());
    
        robo.mover();
    
        robo.setStrategy(new ComportamentoAgressivo());
    
        robo.mover();
    }
}
