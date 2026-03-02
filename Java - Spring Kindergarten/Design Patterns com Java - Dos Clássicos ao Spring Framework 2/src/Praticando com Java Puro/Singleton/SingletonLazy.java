package Singleton;
public class SingletonLazy {
    
    private static SingletonLazy instance;

    private SingletonLazy() {
        super();
        // Construtor privado para evitar instanciamento externo
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
