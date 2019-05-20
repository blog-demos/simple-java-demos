package pers.hai.simple.matrix2;

/**
 * 像素点
 * 2015年12月4日
 * 
 * @author Q-WHai
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class Pixel {

    private String name;
    private PixelType type;
    
    public Pixel(String _name, PixelType _type) {
        name = _name;
        type = _type;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PixelType getType() {
        return type;
    }
    public void setType(PixelType type) {
        this.type = type;
    }
}
