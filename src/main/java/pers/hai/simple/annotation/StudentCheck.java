package pers.hai.simple.annotation;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * TODO
 * <p>
 * Create Time: 2019/5/16 21:51
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class StudentCheck {

    private static final Logger logger = Logger.getLogger(StudentCheck.class);

    public static boolean check(Student student) {
        if (null == student) {
            logger.warn("Object student is NullPoint.");
            return false;
        }

        // 获取Student类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = Student.class.getDeclaredFields();
        boolean flag = true;
        for (Field field : fields) {
            if (field.getName().equals("name")) {
                flag = flag & checkName(student.getName(), field);
            } else if (field.getName().equals("age")) {
                flag = flag & checkAge(student.getAge(), field);
            }
        }

        return flag;
    }

    private static boolean checkName(String name, Field field) {
        NameValidate validate = field.getAnnotation(NameValidate.class);

        if (null == name) {
            logger.info(String.format("%s", validate.isNotNull() ? "姓名不可为空，校验不通过" : "姓名空校验通过：允许空"));
            return !validate.isNotNull();
        } else
            logger.info("姓名不为空，校验通过");

        if (name.length() < validate.minLength()) {
            logger.warn(String.format("姓名最小长度为：%d，当前长度过小", validate.minLength()));
            return false;
        } else if (name.length() > validate.maxLength()) {
            logger.warn(String.format("姓名最大长度为：%d，当前长度过大", validate.maxLength()));
            return false;
        } else
            logger.info("姓名长度合法，校验通过");

        return true;
    }

    private static boolean checkAge(int age, Field field) {
        AgeValidate validate = field.getAnnotation(AgeValidate.class);

        if (age < validate.min()) {
            logger.warn(String.format("最小年龄为：%d，当前年龄已低于最小年龄", validate.min()));
            return false;
        } else if (age > validate.max()) {
            logger.warn(String.format("最大年龄为：%d，当前年龄已高于最大年龄", validate.max()));
            return false;
        } else
            logger.info("年龄大小合法，校验通过");

        return true;
    }
}
