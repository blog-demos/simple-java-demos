package simple.java.jvm;

public class StaticDispatch {

    static abstract class Human {
    }
    
    static class Man extends Human {
    }
    
    static class Woman extends Human {
    }
    
    public void sayHello(Human guy) {
        System.out.println("Hello guy.");
    }
    
    public void sayHello(Man man) {
        System.out.println("Hello man.");
    }
    
    public void sayHello(Woman woman) {
        System.out.println("Hello woman.");
    }
    
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
    }
}
