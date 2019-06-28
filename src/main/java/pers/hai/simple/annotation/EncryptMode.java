package pers.hai.simple.annotation;

import java.lang.annotation.*;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 12:56
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Documented
@Inherited
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptMode {
    EncryptType type() default EncryptType.MD5;
}
