package Singleton;
public class SingletonEager {
    
    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {
        super();
        // Construtor privado para evitar instanciamento externo
    }

    public static SingletonEager getInstance() {
        return instance;
    }
    
}
