package simple.java.cipher.rsa;

/**
 * <p>
 * RSA加密算法的密钥接口
 * </p>
 * 2016年2月19日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public interface RSAKey {

    int getExponent();

    void setExponent(int exponent);

    int getModulus();

    void setModulus(int modulus);
}
