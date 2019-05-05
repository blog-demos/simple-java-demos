package simple.java.refs;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferencesDemo {

    public static void main(String[] args) {
        ReferencesDemo demo = new ReferencesDemo();
        demo.testStrongReference();
        demo.testSoftReference();
        demo.testWeakReference();
        demo.testPhantomReference();
    }
    
    // StrongReference
    private void testStrongReference() {
        String label = new String("ABC");
        System.out.println(label);
    }
    
    // SoftReference
    private void testSoftReference() {
        SoftReference<String> label = new SoftReference<String>(new String("hello"));
        System.out.println(label.get());
        System.gc();
        System.out.println(label.get());
    }
    
    // WeakReference
    private void testWeakReference() {
        WeakReference<String> label = new WeakReference<String>(new String("hello"));
        
        System.out.println(label.get());
        System.gc();    // 通知JVM的gc进行垃圾回收
        System.out.println(label.get());
    }
    
    // PhantomReference
    private void testPhantomReference() {
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(pr.get());
    }
}
