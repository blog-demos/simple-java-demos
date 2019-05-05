package simple.java.obj;

public class Client {

    public static void main(String[] args) {
        SuperObject object = new SubObject();
        System.out.println(((SuperObject)object).sum(4, 5));
        
        System.out.println(object instanceof SuperObject);
        System.out.println(object instanceof SubObject);
    }
}
