package pers.hai.simple.jvm;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * <p>
 * 《深入理解Java虚拟机》 - 8.3.3 p268
 * </p>
 * Create Date: 2016年4月7日
 * Last Modify: 2016年4月7日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Test8_15 {

    class GrandFather {
        void thinking() {
            System.out.println("I'm Grand Father");
        }
    }
    
    class Father extends GrandFather {
        void thinking() {
            System.out.println("I'm Father");
        }
    }
    
    class Son extends Father {
        void thinking() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass());
                methodHandle.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        (new Test8_15().new Son()).thinking();
    }
}
