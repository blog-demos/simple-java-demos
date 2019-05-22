package pers.hai.simple.annotation;

import java.lang.annotation.*;

/**
 * TODO
 * <p>
 * Create Time: 2019/05/22 09:16
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Documented
@Inherited                              // 注解可被继承
@Target(ElementType.FIELD)              // 注解作用于字段、枚举的常量
@Retention(RetentionPolicy.RUNTIME)     // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface NameValidate {
    boolean isNotNull() default true;   // 默认配置名称不可为空
    int minLength() default 1;
    int maxLength() default 16;
}
