package simple.java.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 《深入理解Java虚拟机》 - 7.4.1 p228
 * </p>
 * Create Date: 2016年4月7日
 * Last Modify: 2016年4月7日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class ClassloadTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        ClassLoader myLoader = new ClassLoader() {
            
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        
        Object object = myLoader.loadClass("org.naga.demo.jvm.ClassloadTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof simple.java.jvm.ClassloadTest);
    }
}
