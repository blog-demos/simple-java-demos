package simple.java.web.bean;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1623830395974023484L;

    private String name = "";
    
    private int age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return getName() + ":" + getAge();
    }
}
