package pers.hai.simple.callbacksync;

public class Boss {

    public static void main(String[] args) {
        Manager manager = new Manager(new Programmer());
        manager.entrust();
    }
}
