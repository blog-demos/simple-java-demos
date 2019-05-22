package pers.hai.simple.annotation;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 12:59
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@EncryptMode
public class HttpRequest {

    @EncryptMode(type = EncryptType.SHA1)
    public String request(String content) {
        //
        return "";
    }

    @EncryptMode(type = EncryptType.SHA256)
    public String request2(String content) {
        //
        return "";
    }
}
