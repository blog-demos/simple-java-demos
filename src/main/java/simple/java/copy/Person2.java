package simple.java.copy;

import java.io.Serializable;

/**
 * Created by Naga on 2015/11/25.
 * Blog : http://blog.csdn.net/lemon_tree12138
 * GitHub : https://github.com/William-Hai
 */
public class Person2 implements Serializable {
    
    private static final long serialVersionUID = 119965371824645144L;
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
