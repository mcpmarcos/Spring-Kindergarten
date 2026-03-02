import Singleton.SingletonEager;
import Singleton.SingletonLazy;
import Singleton.SingletonLazyHolder;

public class TestSingleton {
    
    public static void main(String[] args) {

        SingletonLazy instance = SingletonLazy.getInstance();
        System.out.println(instance);

        instance = SingletonLazy.getInstance();
        System.out.println(instance);

        SingletonEager instanceEager = SingletonEager.getInstance();
        System.out.println(instanceEager);

        instanceEager = SingletonEager.getInstance();
        System.out.println(instanceEager);

        SingletonLazyHolder instanceLazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(instanceLazyHolder);

        instanceLazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(instanceLazyHolder);
    }
}
