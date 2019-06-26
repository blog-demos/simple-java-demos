package pers.hai.simple;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pers.hai.simple.model.Student;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-26 14:57
 * Last Modify: 2019-06-26
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class TransientTests {

    @Test
    public void test1() {
        Student student = new Student();
        student.setName("Bob");
        student.setAge(17);
        student.setAddress("asfwe");

        String json = JSON.toJSONString(student);
        System.out.println(json);
    }
}
