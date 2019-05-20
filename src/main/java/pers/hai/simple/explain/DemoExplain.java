package pers.hai.simple.explain;

public class DemoExplain {

    public static void main(String[] args) {
        FruitName fruitName = Apple.class.getAnnotation(FruitName.class);
        FruitColor fruitColor = Apple.class.getAnnotation(FruitColor.class);
        
        System.out.println(fruitName);
        System.out.println(fruitColor);
    }
}
