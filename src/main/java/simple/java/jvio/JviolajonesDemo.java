package simple.java.jvio;

public class JviolajonesDemo {

    public static void main(String[] args) {
        // String fileName = "";
        // Detector detector = new Detector("");
        // detector.getFaces(fileName, 1.2f,1.1f,.05f, 2,true);
        
        String a = "A";
//        String b = "A";
        String c = new String("A");
        System.out.println(a.intern() == c.intern());
    }
}
