package pers.hai.simple.annotation;

import java.lang.annotation.*;

/**
 * TODO
 * <p>
 * Create Time: 2019/05/22 09:18
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Documented
@Inherited
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValidate {
    int min() default 0;
    int max() default 130;
}
