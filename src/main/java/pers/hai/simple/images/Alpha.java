package pers.hai.simple.images;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class Alpha {

    public Alpha() {
        // 创建一个600*400的图象
        BufferedImage image = new BufferedImage(600, 400,
                BufferedImage.TYPE_INT_RGB);
        // 创建java2D对象
        Graphics2D g2d = image.createGraphics();

        // g2d.setBackground(Color.PINK);
        // 填充背景
        g2d.setColor(Color.yellow);
        g2d.fillRect(0, 0, 600, 400);

        // 创建AlphaComposite对象，并设定透明度
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                0.5f);
        g2d.setComposite(ac);
        g2d.setFont(new Font("隶书", Font.PLAIN, 42));
        g2d.setColor(Color.black);
        g2d.drawString("方正粗宋简体透明度为0.5", 20, 40);

        // 画一个背景色为..的长方形
        AlphaComposite ac2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
        g2d.setComposite(ac2);
        g2d.setColor(Color.CYAN);
        g2d.fill3DRect(10, 200, 180, 80, false);

        g2d.dispose();
        try {
            FileOutputStream fs = new FileOutputStream("src/main/images/1.jpg");
            ImageIO.write(image, "jpg", fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Alpha();
    }
}