package pers.hai.simple.clone;

public class Apple implements Cloneable {

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
    }
}
