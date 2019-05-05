package simple.java.jdk.utilapis;

public class Bird implements Flyable {

    private int speed = 15;
    
    @Override
    public void fly() {
        System.out.println("I'm Bird, my speed is " + speed + ".");
    }

}
