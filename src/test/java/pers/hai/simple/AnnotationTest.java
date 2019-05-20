package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.annotation.Student;
import pers.hai.simple.annotation.StudentCheck;
import pers.hai.simple.annotation.User;
import pers.hai.simple.annotation.UserFactory;

/**
 * TODO
 * <p>
 * Create Time: 2019/5/16 21:48
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class AnnotationTest {

    @Test
    public void test1() {
        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

    @Test
    public void test2() {
        Student student = new Student();

        student.setName("liang322");
        student.setAge("1");

        System.out.println(StudentCheck.check(student));
    }
}
