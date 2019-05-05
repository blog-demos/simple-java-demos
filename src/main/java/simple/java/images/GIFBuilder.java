package simple.java.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.core.utils.files.FileSearchUtils;

public class GIFBuilder {

    public static void main(String[] args) {
        try {
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            String[] imgPaths = FileSearchUtils.getAllFileFullName("F:/IMG/GB/0/");
            
            e.start("F:/IMG/GB/0/0-TYPE_3BYTE_BGR.gif");
            for (int i = 1; i < imgPaths.length; i++) {
                e.setDelay(1000);
                BufferedImage bi = ImageIO.read(new File(imgPaths[i]));
                e.addFrame(bi);
            }
            e.finish();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
