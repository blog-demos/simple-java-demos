package pers.hai.simple.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }
    
    public static void main(String[] args) throws Throwable {
        long stamp = System.currentTimeMillis();
        Object object = stamp % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(object).invokeExact("icyfenix");
    }
    
    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", methodType).bindTo(reveiver);
    }
}
