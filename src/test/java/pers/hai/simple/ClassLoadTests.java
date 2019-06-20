package pers.hai.simple;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-20 17:09
 * Last Modify: 2019-06-20
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ClassLoadTests extends Testable {

    @Test
    public void test1() {
        try {
            Class<?> clazz = Class.forName("pers.hai.simple.obj.Model");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            Method[] methods = clazz.getDeclaredMethods();
            logger.info(methods.length);

            Method method = clazz.getMethod("setName", String.class);
            method.invoke(obj, "Bob");

            Method method1 = clazz.getMethod("getName");
            Object obj2 = method1.invoke(obj);
            logger.info(obj2);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            Class<?> clazz = getClass().getClassLoader().loadClass("pers.hai.simple.obj.Model");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            Method[] methods = clazz.getDeclaredMethods();
            logger.info(methods.length);

            Method method = clazz.getMethod("setName", String.class);
            method.invoke(obj, "Bob");

            Method method1 = clazz.getMethod("getName");
            Object obj2 = method1.invoke(obj);
            logger.info(obj2);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            Class<?> clazz = Class.forName("pers.hai.simple.obj.Model");
            Field field = clazz.getDeclaredField("CONST_1");
            System.out.println(field);
            System.out.println(field.get(clazz));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test4() {
        try {
            Class<?> clazz = getClass().getClassLoader().loadClass("pers.hai.simple.obj.Model");
            Field field = clazz.getDeclaredField("CONST_1");
            System.out.println(field);
            System.out.println(field.get(clazz));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
