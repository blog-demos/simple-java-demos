package pers.hai.simple.annotation;

import java.lang.annotation.*;

/**
 * TODO
 * <p>
 * Create Time: 2019/5/16 21:49
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    int min() default 1;
    int max() default 10;
    boolean isNotNull() default true;
}