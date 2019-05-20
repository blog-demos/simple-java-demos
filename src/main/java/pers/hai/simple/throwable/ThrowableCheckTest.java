package pers.hai.simple.throwable;

public class ThrowableCheckTest {

    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        
        a.callCheck();
        b.callCheck();
    }
}
