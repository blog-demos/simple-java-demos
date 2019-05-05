package simple.java.cipher.rsa;

import org.core.utils.files.FileReadUtils;
import org.core.utils.nums.RandomUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 * RSA主算法
 * </p>
 * <p>
 * 参考《算法的乐趣》
 * </p>
 * 2016年2月19日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class RSA {

    public static final String PUBLIC_KEY = "public_key";
    public static final String PRIVATE_KEY = "private_key";
    
    /**
     * 获得(公/私)密钥
     * 
     * @return
     *      (公/私)密钥
     */
    public final Map<String, RSAKey> getCipherKeys() {
        Map<String, RSAKey> keys = new HashMap<String, RSAKey>();
        RSAPublicKey publicKey = new RSAPublicKey();
        RSAPrivateKey privateKey = new RSAPrivateKey();
        
        int[] primes = getRandomPrimes(2);
        System.out.println("选取的素数对为：" + Arrays.toString(primes));
        
        int modulus = modulus(primes[0], primes[1]);
        System.out.println("模：" + modulus);
        
        int euler = euler(primes[0], primes[1]);
        System.out.println("模的欧拉数φ(n)：" + euler);
        
        int e = cipherExponent(euler);
        System.out.println("加密指数：" + e);
        
        int inverse = inverse(euler, e);
        
        publicKey.setExponent(e);
        publicKey.setModulus(modulus);
        
        privateKey.setExponent(inverse);
        privateKey.setModulus(modulus);
        
        keys.put(RSA.PUBLIC_KEY, publicKey);
        keys.put(RSA.PRIVATE_KEY, privateKey);
        
        return keys;
    }
    
    /**
     * 加密
     * 
     * @param plaintext
     *      明文
     * @param key
     *      公钥
     * @return
     *      密文
     */
    public int encode(int plaintext, RSAPublicKey key) {
        return modularPower(plaintext, key.getExponent(), key.getModulus());
    }
    
    /**
     * 解密
     * 
     * @param chipertext
     *      密文
     * @param key
     *      密钥
     * @return
     *      明文
     */
    public int decode(int chipertext, RSAPrivateKey key) {
        return modularPower(chipertext, key.getExponent(), key.getModulus());
    }

    // 随机生成count个素数
    private final int[] getRandomPrimes(int count) {
        List<Integer> indexs = new RandomUtils().randomSet(5, 20, count);
        int[] primes = new int[count];

        List<String> primeLabels = null;
        try {
            primeLabels = FileReadUtils.readLines("./data/prime_table");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < primes.length; i++) {
            primes[i] = Integer.parseInt(primeLabels.get(indexs.get(i)));
        }

        return primes;
    }

    // 计算公共模数
    private final int modulus(int p, int q) {
        return p * q;
    }

    // 计算欧拉数
    private final int euler(int p, int q) {
        return (p - 1) * (q - 1);
    }

    // 计算加密指数
    private final int cipherExponent(int euler) {
        Random random = new Random();

        int e = 7;
        do {
            e = random.nextInt(euler - 1);
        } while (!isCoprime(e, euler) || e <= 1); // 这里的指数e如果为1，可能会导致加密无效，解密结果为1

        return e;
    }

    // 判断两个数互素
    private final boolean isCoprime(int number1, int number2) {

        int sqrt = (int) Math.sqrt(Math.max(number1, number2));
        for (int i = 2; i <= sqrt; i++) {
            if (number1 % i == 0 && number2 % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    // 计算“模的逆元”
    // (d * e) ≡ 1 mod euler
    private final int inverse(int euler, int e) {
        int[] m = { 1, 0, euler };
        int[] n = { 0, 1, e };
        int[] temp = new int[3];
        int q = 0; // 初始化
        boolean flag = true;
        while (flag) {
            q = m[2] / n[2];
            for (int i = 0; i < 3; i++) {
                temp[i] = m[i] - q * n[i];
                m[i] = n[i];
                n[i] = temp[i];
            }
            if (n[2] == 1) {
                if (n[1] < 0) {
                    n[1] = n[1] + euler;
                }
                return n[1];
            }
            if (n[2] == 0) {
                flag = false;
            }
        }
        return 0;
    }
    
    // 模幂运算
    private final int modularPower(int base, int e, int modular) {
        int result = 1;
        do {
            if (isOdd(e)) {
                result = (result * (base % modular)) % modular;
                e -= 1;
            } else {
                base = (base * base) % modular;
                e /= 2;
            }
        } while (e > 0);
        
        result %= modular;
        
        return result;
    }
    
    // 判定数字的奇偶性
    private final boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
