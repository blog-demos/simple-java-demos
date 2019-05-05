package simple.java.cipher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

/**
 * RSA算法 公钥加密 非对称加密
 * 
 * @author stone
 * @date 2014-03-11 00:28:38
 */
public class RSA {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String CIPHER_ALGORITHM_ECB1 = "RSA/ECB/PKCS1Padding";
//    public static final String CIPHER_ALGORITHM_ECB2 = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding"; // 不能用
//    public static final String CIPHER_ALGORITHM_ECB3 = "OAEPWithSHA-256AndMGF1Padding"; // 不能用

    static PublicKey publicKey;
    static PrivateKey privateKey;
    static Cipher cipher;
    static KeyPair keyPair;

    public static void main(String[] args) throws Exception {
        method1("RSA是第一个既能用于数据加密也能用于数字签名的算法。斯柯达U*(Sfsad7f()*^%%$");
        method2("斯柯达U*(Sfsad7f()*^%%$");
        method3("斯柯达U*(Sfsad7f()*^%%$");

    }

    /**
     * 公钥加密，私钥解密 使用默认CIPHER_ALGORITHM_ECB1
     * 
     * @param str
     * @throws Exception
     */
    static void method1(String str) throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        KeyPair keyPair = keyGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); // 公钥加密
        byte[] encrypt = cipher.doFinal(str.getBytes());
        System.out.println("公钥加密后1：" + Arrays.toString(encrypt));

        cipher.init(Cipher.DECRYPT_MODE, privateKey); // 私钥解密
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("私钥解密后1：" + new String(decrypt));
    }

    /**
     * 私钥加密，公钥解密 使用默认CIPHER_ALGORITHM_ECB1
     * 
     * @param str
     * @throws Exception
     */
    static void method2(String str) throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator
                .getInstance(KEY_ALGORITHM);
        KeyPair keyPair = keyGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey); // 私钥加密
        byte[] encrypt = cipher.doFinal(str.getBytes());
        System.out.println("私钥加密后2：" + Arrays.toString(encrypt));

        cipher.init(Cipher.DECRYPT_MODE, publicKey);// 公钥解密
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("公钥解密后2：" + new String(decrypt));
    }

    /**
     * 私钥加密，公钥解密 使用CIPHER_ALGORITHM_ECB1 = RSA/ECB/PKCS1Padding
     * 
     * @param str
     * @throws Exception
     */
    static void method3(String str) throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator
                .getInstance(KEY_ALGORITHM);
        KeyPair keyPair = keyGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB1);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey); // 私钥加密
        byte[] encrypt = cipher.doFinal(str.getBytes());
        System.out.println("私钥加密后3：" + Arrays.toString(encrypt));

        cipher.init(Cipher.DECRYPT_MODE, publicKey);// 公钥解密
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("公钥解密后3：" + new String(decrypt));
    }
}