package pers.hai.simple.annotation;

/**
 * TODO
 * <p>
 * Create Time: 21:45 2019/5/16
 * Last Modify: 2019/5/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    String value() default "";
}
