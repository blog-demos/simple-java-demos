package simple.java.enu;

/**
 * 测试枚举类型
 * 
 * @author Q-WHai
 * Blog : https://qwhai.blog.csdn.net/
 */
public class EnumTest {

    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season + " " + season.getDesc());
        }
    }
}
