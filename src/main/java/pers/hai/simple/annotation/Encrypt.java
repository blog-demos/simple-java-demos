package pers.hai.simple.annotation;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-27 18:36
 * Last Modify: 2019-06-27
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class Encrypt {

    @EncryptMode(type = EncryptType.MD5)
    public String encrypt(String content) {
        return String.format("5ca191e0-6534-4872-bf4b-0803fc96f5c1|%s", content);
    }
}
