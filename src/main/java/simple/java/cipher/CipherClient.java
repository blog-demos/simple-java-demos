package simple.java.cipher;

import java.util.Arrays;

import org.core.utils.cipher.impl.SHA1Impl;
import org.core.utils.cipher.impl.SMS4Impl;
import org.core.utils.cipher.poke.CipherUtils;
import org.core.utils.excep.IrreversibleException;
import org.core.utils.excep.StrategyException;

public class CipherClient {

    public static void main(String[] args) {
        cipher();
    }
    
    private static void cipher() {
        byte[] key = { 0x01, 0x23, 0x45, 0x67, (byte) 0x89,
                (byte) 0xab, (byte) 0xcd, (byte) 0xef, (byte) 0xfe, (byte) 0xdc,
                (byte) 0xba, (byte) 0x98, 0x76, 0x54, 0x32, 0x10 };
        
        CipherUtils cipher = new CipherUtils(new SMS4Impl());
        byte[] ciphertextBytes = cipher.encryption("中国", key);
        System.out.println(Arrays.toString(ciphertextBytes));
        try {
            System.out.println(cipher.decryption(ciphertextBytes, key));
        } catch (StrategyException | IrreversibleException e) {
            e.printStackTrace();
        }
        
        cipher = new CipherUtils(new SHA1Impl());
        cipher.encryption("Hello", key);
    }
}
