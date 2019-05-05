package simple.java.images;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * <p>
 * 朴素的模糊算法
 * </p>
 * <p>
 * 在朴素的模糊算法中，只是计算每个点的平均值
 * </p>
 * <p>
 * 结果就是模糊度不够，图片变暗。这是一种效果很差的模糊算法
 * </p>
 * 2015年12月29日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
@Deprecated
public class NativeFuzzyImage {
    
    public static void main(String[] args) throws IOException {
        
        BufferedImage bufferedImage = ImageIO.read(new File("F:/IMG/GB/3.jpg"));
        System.out.println(bufferedImage);
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        int[][] matrix = new int[3][3];
        int[] values = new int[9];
        for (int i = 0; i < width / 2; i++) {
            for (int j = 0; j < height; j++) {
                readPixel(bufferedImage, i, j, values);
                fillMatrix(matrix, values);
                bufferedImage.setRGB(i, j, avgMatrix(matrix));
            }
        }
        
        ImageIO.write(bufferedImage, "jpg", new File("F:/IMG/GB/3-nf.jpg"));
    }

    /**
     * 读取图片上的像素点
     * 
     * @param img
     *      图片
     * @param x
     *      像素的横坐标
     * @param y
     *      像素的纵坐标
     * @param pixels
     *      保存图片中以(x, y)为中心点，半径为1的周围9个点像素RGB值
     */
    private static void readPixel(BufferedImage img, int x, int y, int[] pixels) {
        int xStart = x - 1;
        int yStart = y - 1;
        int current = 0;
        for (int i = xStart; i < 3 + xStart; i++) {
            for (int j = yStart; j < 3 + yStart; j++) {
                int tx = i;
                // 边界处理
                if (tx < 0) {
                    tx = -tx;
                } else if (tx >= img.getWidth()) {
                    tx = x;
                }

                int ty = j;
                // 边界处理
                if (ty < 0) {
                    ty = -ty;
                } else if (ty >= img.getHeight()) {
                    ty = y;
                }
                pixels[current++] = img.getRGB(tx, ty);
            }
        }
    }

    /**
     * 将读取的像素RGB值保存到二维数组中
     * 
     * @param matrix
     *      二维数组
     * @param values
     *      一维数组
     */
    private static void fillMatrix(int[][] matrix, int... values) {
        int filled = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] x = matrix[i];
            for (int j = 0; j < x.length; j++) {
                x[j] = values[filled++];
            }
        }
    }

    /**
     * 计算平均值重新写入图片
     * 
     * @param matrix
     *      保存的二维数组
     * @return
     *      新的颜色RGB
     */
    private static int avgMatrix(int[][] matrix) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] x = matrix[i];
            for (int j = 0; j < x.length; j++) {
                if (j == 1) {
                    continue;
                }
                Color c = new Color(x[j]);
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
            }
        }
        return new Color(r / 8, g / 8, b / 8).getRGB();
    }
}