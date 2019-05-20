package pers.hai.simple.jvm;

public class VariableSoltTest {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
//            placeholder = null;
        }
        int a = 0;
        System.gc();
    }
}
