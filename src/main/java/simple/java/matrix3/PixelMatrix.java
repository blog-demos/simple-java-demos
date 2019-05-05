package simple.java.matrix3;

import org.core.utils.logs.LogUtils;

/**
 * 矩阵变换
 * 2015年12月4日
 * 
 * @author Q-WHai
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class PixelMatrix {

    static Pixel[] pixelYs = null;
    static Pixel[] pixelUs = null;
    static Pixel[] pixelVs = null;
    
    static {
        pixelYs = new Pixel[12 * 12];
        for (int i = 0; i < 12 * 12; i++) {
            pixelYs[i] = new Pixel(PixelType.Y.name() + (i + 1), PixelType.Y);
        }
        
        pixelUs = new Pixel[3 * 12];
        for (int i = 0; i < 3 * 12; i++) {
            pixelUs[i] = new Pixel(PixelType.U.name() + (i + 1), PixelType.U);
        }
        
        pixelVs = new Pixel[3 * 12];
        for (int i = 0; i < 3 * 12; i++) {
            pixelVs[i] = new Pixel(PixelType.V.name() + (i + 1), PixelType.V);
        }
    }
    
    private static void matrixTranspose(Pixel[] matrixY, Pixel[] matrixU, Pixel[] matrixV) {
        if (null == matrixY || null == matrixU || null == matrixV) {
            return;
        }
        
        int clo = (int) Math.sqrt(matrixY.length); // 虚拟一个二维数组的列号
        
        // 将U附加到Y的后面
        int matrixULength = matrixU.length;
        for (int i = 0; i < matrixULength; i++) {
            int index = 0;
            int level = i / (clo / 2); // U的相对层次
            int firstYIndex = 0 + ((level + 1) - 1) * (2 * clo); // 每行的第一个Y的下标 (*2是因为隔行了)
            index = firstYIndex + (((i + 1) % (clo / 2) == 0 ? clo / 2 : (i + 1) % (clo / 2)) - 1) * 2;
            matrixY[index].setExtra(matrixU[i]);
        }
        
        // 将V附加到Y的后面
        int matrixVLength = matrixV.length;
        for (int i = 0; i < matrixVLength; i++) {
            int index = 0;
            int level = i / (clo / 2); // V的相对层次
            int firstYIndex = clo + ((level + 1) - 1) * (2 * clo); // 每行的第一个Y的下标 (*2是因为隔行了)
            index = firstYIndex + (((i + 1) % (clo / 2) == 0 ? clo / 2 : (i + 1) % (clo / 2)) - 1) * 2;
            matrixY[index].setExtra(matrixV[i]);
        }
    }
    
    private static void printMatrix(Pixel[] matrixY) {
        int clo = (int) Math.sqrt(matrixY.length); // 虚拟一个二维数组的列号
        
        int currentIndex = 0;
        
        int totalLength = matrixY.length;
        for (int i = 0; i < totalLength; i++) {
            if (matrixY[i].hasExtra()) {
                System.out.print(matrixY[i].getName() + "\t" + matrixY[i].getExtra().getName() + "\t");
                currentIndex += 2;
            } else {
                System.out.print(matrixY[i].getName() + "\t");
                currentIndex++;
            }
            
            if (currentIndex % (clo * 3 / 2) == 0) {
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            matrixTranspose(pixelYs, pixelUs, pixelVs);
        }
        LogUtils.printTimeUsed(startStamp);
        printMatrix(pixelYs);
    }
}
