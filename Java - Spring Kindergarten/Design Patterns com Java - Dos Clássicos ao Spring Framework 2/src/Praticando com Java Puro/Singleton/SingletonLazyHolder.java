package Singleton;
public class SingletonLazyHolder {
    

    private static class InstanceHolder {
        private static final SingletonLazyHolder instance = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.instance;
    }
}
