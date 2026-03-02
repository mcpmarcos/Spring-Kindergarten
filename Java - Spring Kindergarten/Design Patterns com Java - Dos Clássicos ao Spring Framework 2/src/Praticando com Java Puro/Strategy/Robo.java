package Strategy;

public class Robo {
    
    // Clçasse que ocupa o papel de CONTEXTO, segundo o padrão Strategy

    // Necessário instanciar a interface de comportamento para o robo, para que ele possa usar as estratégias

    // Após a instanciação da interface, devo criar um método setStrategy() / setComportamento() para que o robo possa mudar seu comportamento em tempo de execução 

    private IComportamento strategy;

    public void setStrategy(IComportamento strategy) {
        this.strategy = strategy;
    }

    public void mover() {
        strategy.mover();
    }

}
