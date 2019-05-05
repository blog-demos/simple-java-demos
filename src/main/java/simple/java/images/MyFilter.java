package simple.java.images;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * <p>
 * 透明过滤器
 * </p>
 * 2015年12月31日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
class MyFilter extends RGBImageFilter {
    
    // 继承它实现图象ARGB的处理
    int alpha = 0;

    public MyFilter(int alpha) {// 构造器，用来接收需要过滤图象的尺寸，以及透明度
        this.canFilterIndexColorModel = true;
        // TransparentImageFilter类继承自RGBImageFilter，它的构造函数要求传入原始图象的宽度和高度。
        // 该类实现了filterRGB抽象函数
        // ，缺省的方式下，该函数将x，y所标识的象素的ARGB值传入，程序员按照一定的程序逻辑处理后返回该象素新的ARGB值
        this.alpha = alpha;
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {
        DirectColorModel dcm = (DirectColorModel) ColorModel.getRGBdefault();
        // DirectColorModel类用来将ARGB值独立分解出来
        int red = dcm.getRed(rgb);
        int green = dcm.getGreen(rgb);
        int blue = dcm.getBlue(rgb);
        
        @SuppressWarnings("unused")
        int alp = dcm.getAlpha(rgb);

        if (red == 255 && blue == 255 && green == 255) { // 如果像素为白色，则让它透明
            alpha = 0;
        } else {
            alpha = 255;
        }
        return alpha << 24 | red << 16 | green << 8 | blue;// 进行标准ARGB输出以实现图象过滤
    }

    public static void main(String[] args) {
        //try {
        //    BufferedImage image = ImageIO.read(new FileInputStream("F:/IMG/0.jpg"));
//
        //    // 读取图标
        //    BufferedImage imageBiao = ImageIO.read(new FileInputStream("F:/IMG/0-icon.jpg"));
        //
        //    Graphics2D g = image.createGraphics();
        //    g.setColor(Color.YELLOW);
        //    g.setFont(new Font("华文中宋", Font.LAYOUT_LEFT_TO_RIGHT, 48));
        //    g.drawString("图像合成示例",100, image.getHeight() - 400);
        //
        //    // 写入图标
        //    ImageFilter imgf = new MyFilter(255);
        //    FilteredImageSource fis = new FilteredImageSource(imageBiao.getSource(), imgf);
        //
        //    Image im = Toolkit.getDefaultToolkit().createImage(fis);
        //    g.drawImage(im, 0, 0, imageBiao.getWidth(null), imageBiao.getHeight(null), null);
        //    g.dispose();
        //
        //    FileOutputStream out = new FileOutputStream("F:/IMG/0-com.gif");
        //    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        //    encoder.encode(image);
        //    out.close();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    }
}