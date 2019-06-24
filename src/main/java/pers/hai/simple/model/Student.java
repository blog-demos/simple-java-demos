package pers.hai.simple.model;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 14:57
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class Student {

    private String name;
    private int age;

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
    public int hashCode() {
        return String.format("%s|%d", getName(), getAge()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            return false;

        return obj.hashCode() == hashCode();
    }
}
