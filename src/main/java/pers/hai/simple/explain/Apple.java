package pers.hai.simple.explain;

public class Apple {

    @FruitName(fruitName="Apple")
    private String name = null;
    
    @FruitColor(fillColor=Color.Red)
    private Color color = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void display() {
        System.out.println(name + " 的颜色是：" + color);
    }
}
