package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.annotation.*;
import pers.hai.util.commons.scan.ClassScanning;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * TODO
 * <p>
 * Create Time: 2019/05/16 21:48
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class AnnotationTest extends Testable {

    @Test
    public void annotationField1() {
        Student student = new Student();

        student.setName("jobs");
        student.setAge(17);

        logger.info(StudentCheck.check(student));
    }

    @Test
    public void annotationParameter1() {
        Student student = new Student();

        student.setName("jobs");
        student.setAge(17);

        logger.info(StudentCheck.check(student));
    }

    @Test
    public void anntationMethod1() {
        ClassScanning scanning = new ClassScanning();
        var classes = scanning.getClasses("pers.hai.simple.annotation", false);
        classes.forEach((clazz) -> {
            if (!clazz.isInterface() && !clazz.isEnum()) {
                var annotations = clazz.getAnnotations();
                if (0 < annotations.length && annotations[0] instanceof EncryptMode){
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method method : methods) {
                        logger.info(method);
                        EncryptMode mode = method.getAnnotation(EncryptMode.class);
                        logger.info(mode.type());
                    }
                }
            }
        });
    }

    @Test
    public void anntationMethod2() {
        EncryptCheck check = new EncryptCheck();
        logger.info(String.format("result = %s", check.encrypt(new Encrypt())));
    }
}
