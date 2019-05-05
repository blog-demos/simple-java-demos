package simple.java.cipher.rsa;

import java.util.Map;

/**
 * <p>
 * 测试客户端
 * </p>
 * 2016年2月19日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Client {

    public static void main(String[] args) {
        int M = 512; // 明文
        
        RSA cipher = new RSA();
        Map<String, RSAKey> keys = cipher.getCipherKeys();
        RSAPublicKey publicKey = (RSAPublicKey)keys.get(RSA.PUBLIC_KEY);
        RSAPrivateKey privateKey = (RSAPrivateKey)keys.get(RSA.PRIVATE_KEY);
        
        int C = cipher.encode(M, publicKey);
        int CM = cipher.decode(C, privateKey);
        
        System.out.println("密文：" + C);
        System.out.println("明文：" + CM);
    }
}
