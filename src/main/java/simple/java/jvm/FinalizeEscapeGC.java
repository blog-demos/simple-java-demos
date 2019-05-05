package simple.java.jvm;

import java.util.BitSet;

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;
    
    public void isAlive() {
        System.out.println("Yes, I am still alive.");
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed.");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
    
    public static void main(String[] args) throws InterruptedException {
        BitSet set = new BitSet();
        set.set(8);
        set.set(0, false);
        set.set(0);
        System.out.println(set.get(0));
        
//        SAVE_HOOK = new FinalizeEscapeGC();
//        
//        SAVE_HOOK = null;
//        System.gc();
//        
//        Thread.sleep(500);
//        if (SAVE_HOOK != null) {
//            SAVE_HOOK.isAlive();
//        } else {
//            System.out.println("No, I am dead.");
//        }
//        
//        SAVE_HOOK = null;
//        System.gc();
//        
//        Thread.sleep(500);
//        if (SAVE_HOOK != null) {
//            SAVE_HOOK.isAlive();
//        } else {
//            System.out.println("No, I am dead.");
//        }
    }
}
