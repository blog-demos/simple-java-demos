package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.model.Student;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 14:58
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class EqualsTests {

    @Test
    public void test1() {
        Student stu1 = new Student();
        stu1.setName("Alice");
        stu1.setAge(18);

        Student stu2 = new Student();
        stu2.setName("Alice");
        stu2.setAge(18);

        System.out.println(String.format("stu1.hashCode = %d,  stu2.hashCode = %d", stu1.hashCode(), stu2.hashCode()));
        System.out.println(String.format("stu1.equals(stu2) ? %s", stu1.equals(stu2)));
        System.out.println(String.format("stu1 == stu2 ? %s", stu1 == stu2));
    }
}
