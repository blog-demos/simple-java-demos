package simple.java.generic;

public class GenericsTest {

    public static void main(String[] args) {
        
        // 普通泛型
        Point<String> point = new Point<>();
        point.setVar("Hello");
        System.out.println(point.getVar().length());
        
        Person<String, Integer> person = new Person<>();
        person.setKey("小明");
        person.setValue(18);
        System.out.println(person.getKey() + " : " + person.getValue());
        
        // 通配符
        printGenerics(point);
        
        // 受限泛型
        Point<Integer> num = new Point<>();
        num.setVar(15);
        printGenericsSubLimit(num);
        printGenericsSuperLimit(point);
        
        // 泛型接口
        Info<String> info = null;
        info = new InfoImpl<String>("小红");
        System.out.println("内容 : " + info.getVar());
        
        // 泛型方法
        GenericsFunDemo funDemo = new GenericsFunDemo();
        System.out.println(funDemo.getVar("哈哈"));
        System.out.println(funDemo.getVar(56));
        System.out.println(funDemo.getVar(83.5));
        
        // 泛型数组
        printGenericsArray(getGenericsArray(1, 2, 3, 4, 5));
        
        // 泛型的嵌套
        Person<String, Point<String>> person2 = new Person<>();
        Point<String> address = new Point<>();
        address.setVar("南京");
        person2.setKey("地址");
        person2.setValue(address);
        System.out.println(person2.getKey() + " : " + person2.getValue());
    }
    
    private static void printGenerics(Point<?> point) {
        System.out.println("内容 : " + point);
    }
    
    private static void printGenericsSubLimit(Point<? extends Number> point) {
        System.out.println("内容 : " + point);
    }
    
    private static void printGenericsSuperLimit(Point<? super String> point) {
        System.out.println("内容 : " + point);
    }
    
    @SafeVarargs
    private static <T> T[] getGenericsArray(T ... args) {
        return args;
    }
    
    private static <T> void printGenericsArray(T param[]) {
        for (T t : param) {
            System.out.println(t);
        }
    }
}
