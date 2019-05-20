package pers.hai.simple.images;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pers.hai.util.commons.math.MathUtils;

/**
 * <p>
 * 高斯模糊算法(两次一维)
 * </p>
 * <p>
 * 基于二维环境下的正态分布
 * </p>
 * <p>
 * 程序参考： http://www.ruanyifeng.com/blog/2012/11/gaussian_blur.html
 * http://blog.csdn.net/jia20003/article/details/7234741
 * </p>
 * 2015年12月29日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/
 *      lemon_tree12138</a>
 * @version 0.1.1
 */
@Deprecated
public class GaussianBlurDoubleOneDimen {

    private int radius;
    private int round;

    // 高斯函数的权重矩阵
    private float[] normal_distribution = null;

    public GaussianBlurDoubleOneDimen(int _round, int _radius) {
        round = _round;
        radius = _radius;
        initEvent(radius, 1.5f);
    }

    public static void main(String[] args) throws IOException {
        GaussianBlurDoubleOneDimen blur = new GaussianBlurDoubleOneDimen(1, 1);
        blur.gaussianBlur("F:\\Wall Paper\\3.jpg",
                "F:\\Wall Paper\\3" + blur.getSaveFileName() + ".jpg");
    }

    /**
     * 基于正态分布的图片高斯模糊
     * 
     * @param sourcePath
     *            图片原路径
     * @param targetPath
     *            图片目标路径
     * @throws IOException
     *             读写异常
     */
    public void gaussianBlur(String sourcePath, String targetPath)
            throws IOException {
        gaussianBlur(sourcePath, targetPath, round, radius);
    }

    /**
     * 基于正态分布的图片高斯模糊
     * 
     * @param sourcePath
     *            图片原路径
     * @param targetPath
     *            图片目标路径
     * @param round
     *            轮循高斯模糊的次数
     * @param radius
     *            高斯模糊半径
     * @throws IOException
     *             读写异常
     */
    public void gaussianBlur(String sourcePath, String targetPath, int round,
            int radius) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(sourcePath));
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        int matrixLength = 2 * radius + 1;
        int[] matrix = new int[matrixLength];

        for (int r = 0; r < round; r++) {
            // 横向
            for (int y = 0; y < height; y++) {
                for (int i = 0; i < width; i++) {
                    readPixel(bufferedImage, i, y, matrix, 0);
                    bufferedImage.setRGB(i, y, avgMatrix(matrix));
                }
            }

            // 纵向
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    readPixel(bufferedImage, x, y, matrix, 1);
                    bufferedImage.setRGB(x, y, avgMatrix(matrix));
                }
            }
        }

        ImageIO.write(bufferedImage, "png", new File(targetPath));
    }

    /*
     * 初始化任务
     * 
     * @param n 二维高斯的范围[-n, n]
     * 
     * @param σ 标准方差
     */
    private void initEvent(int n, float σ) {
        normal_distribution = MathUtils.getOneDimenGaussianFunction(n, σ);
    }

    private String getSaveFileName() {
        return "-rou" + round + "-rad" + radius;
    }

    /**
     * 
     * 读取图片上的像素点
     * 
     * @param img
     *            图片
     * @param x
     *            像素的横坐标
     * @param y
     *            像素的纵坐标
     * @param pixels
     *            保存图片中以(x, y)为中心点，半径为1的周围n个点像素RGB值
     * @param direction
     *            高斯的方向
     */
    private void readPixel(BufferedImage img, int x, int y, int[] pixels,
            int direction) {
        int radius = (int) ((Math.sqrt(pixels.length) - 1) / 2);
        int raw = 2 * radius + 1;
        int clo = 2 * radius + 1;

        int xStart = x - radius;
        int yStart = y - radius;
        int current = 0;

        // 横向
        if (direction == 0) {
            for (int i = xStart; i < clo + xStart; i++) {
                // 边界处理
                int tx = i;
                if (tx < 0) {
                    tx = -tx;
                } else if (tx >= img.getWidth()) {
                    tx = x;
                }

                pixels[current++] = img.getRGB(tx, y);
            }
        } else {
            // 纵向
            for (int j = yStart; j < raw + yStart; j++) {
                int ty = j;
                // 边界处理
                if (ty < 0) {
                    ty = -ty;
                } else if (ty >= img.getHeight()) {
                    ty = y;
                }

                pixels[current++] = img.getRGB(x, ty);
            }
        }
    }

    /*
     * 计算平均值重新写入图片
     * 
     * @param matrix 保存的二维数组
     * 
     * @return 新的颜色RGB
     */
    private int avgMatrix(int[] matrix) {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int i = 0; i < matrix.length; i++) {
            Color color = new Color(matrix[i]);
            red += (normal_distribution[i] * color.getRed());
            green += (normal_distribution[i] * color.getGreen());
            blue += (normal_distribution[i] * color.getBlue());
        }
        return new Color(red, green, blue).getRGB();
    }
}
