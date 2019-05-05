package simple.java.matrix3;

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
    
    private Pixel extra;
    
    public Pixel(String _name, PixelType _type) {
        name = _name;
        type = _type;
        extra = null;
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

    public Pixel getExtra() {
        return extra;
    }

    public void setExtra(Pixel extra) {
        this.extra = extra;
    }
    
    public boolean hasExtra() {
        if (extra != null) {
            return true;
        }
        
        return false;
    }
}
