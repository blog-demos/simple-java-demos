package pers.hai.simple.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-27 18:38
 * Last Modify: 2019-06-27
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class EncryptCheck {

    private static final Logger logger = LoggerFactory.getLogger(EncryptCheck.class);

    public String encrypt(Encrypt e) {
        if (null == e) {
            logger.warn("Object e is NullPoint.");
            return "";
        }

        String result = "";

        Encrypt encrypt = new Encrypt();
        Method[] methods = Encrypt.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("encrypt")) {
                EncryptMode mode = method.getAnnotation(EncryptMode.class);
                if (EncryptType.MD5 == mode.type())
                    result = String.format("%s|MD5", encrypt.encrypt("Hello"));
                else if (EncryptType.SHA1 == mode.type())
                    result = String.format("%s|SHA1", encrypt.encrypt("Hello"));
                else if (EncryptType.SHA256 == mode.type())
                    result = String.format("%s|SHA256", encrypt.encrypt("Hello"));
            }
        }

        return result;
    }
}
