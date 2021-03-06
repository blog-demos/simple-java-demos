package pers.hai.simple.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//定义了一个接口
interface Hello {
    public String getInfos1();

    public String getInfos2();

    public void setInfo(String infos1, String infos2);

    public void display();
}

// 定义它的实现类
class HelloImplements implements Hello {

    private volatile String infos1;

    private volatile String infos2;

    public String getInfos1() {
        return infos1;
    }

    public String getInfos2() {
        return infos2;
    }

    public void setInfo(String infos1, String infos2) {
        this.infos1 = infos1;
        this.infos2 = infos2;
    }

    public void display() {
        System.out.println("\t\t" + infos1 + "\t" + infos2);
    }
}

// 定义AOP的Agent
class AOPFactory implements InvocationHandler {

    private Object proxyed;

    public AOPFactory(Object proxyed) {
        this.proxyed = proxyed;
    }

    public void printInfo(String info, Object... args) {
        System.out.println(info);
        if (args == null) {
            System.out.println("\t空值。");
        } else {
            for (Object obj : args) {
                System.out.println(obj);
            }
        }
    }

    public Object invoke(Object proxyed, Method method, Object[] args)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        System.out.println("\n\n====>调用方法名：" + method.getName());
        Class<?>[] variables = method.getParameterTypes();
        for (Class<?> typevariables : variables) {
            System.out.println("=============>" + typevariables.getName());
        }
        printInfo("传入的参数为：", args);
        Object result = method.invoke(this.proxyed, args);
        printInfo("返回的参数为：", result);
        printInfo("返回值类型为：", method.getReturnType());
        return result;
    }
}

// 测试调用类
public class DynamicProxy {

    public static Object getBean(String className)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        Object obj = Class.forName(className).newInstance();
        InvocationHandler handler = new AOPFactory(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);
    }

    public static void main(String[] args) {
        try {
            Hello hello = (Hello) getBean("dynamic.HelloImplements");
            hello.setInfo("xieyu1", "xieyu2");
            hello.getInfos1();
            hello.getInfos2();
            hello.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}