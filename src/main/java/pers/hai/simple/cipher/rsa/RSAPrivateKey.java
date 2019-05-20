package pers.hai.simple.cipher.rsa;

/**
 * <p>
 * RSA的私钥
 * </p>
 * 2016年2月19日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class RSAPrivateKey implements RSAKey {

    private int exponent;
    
    private int modulus;

    @Override
    public int getExponent() {
        return exponent;
    }

    @Override
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public int getModulus() {
        return modulus;
    }

    @Override
    public void setModulus(int modulus) {
        this.modulus = modulus;
    }
}
