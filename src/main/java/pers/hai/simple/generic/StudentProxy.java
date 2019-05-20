package pers.hai.simple.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentProxy implements Human {

    private Student student = null;
    
    public StudentProxy(Student _student) {
        student = _student;
    }
    
    public void setName(String _name) {
        try {
            Class<?> clazz = Class.forName(student.getClass().getName());
            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);
            method.invoke(student, _name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getName() {
        return student.getName();
    }

}
