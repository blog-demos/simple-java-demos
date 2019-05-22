package pers.hai.simple.annotation;

/**
 * TODO
 * <p>
 * Create Time: 2019/5/16 21:50
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class Student {

    @NameValidate(minLength = 2, maxLength = 10, isNotNull = false)
    private String name;

    @AgeValidate(min = 6, max = 20)
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
