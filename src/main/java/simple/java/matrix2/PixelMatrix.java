package simple.java.matrix2;

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

    static Pixel[][] pixels = null;
    static Pixel[][] pixels2 = null;
    static Pixel[][] pixels3 = null;
    
    static {
        pixels = new Pixel[6][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                pixels[i][j] = new Pixel(PixelType.Y.name() + (i * 4 + j + 1), PixelType.Y);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            pixels[4][i] = new Pixel(PixelType.V.name() + (i + 1), PixelType.V);
        }
        
        for (int i = 0; i < 4; i++) {
            pixels[5][i] = new Pixel(PixelType.U.name() + (i + 1), PixelType.U);
        }
    }
    
    static {
        pixels2 = new Pixel[12][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pixels2[i][j] = new Pixel(PixelType.Y.name() + (i * 8 + j + 1), PixelType.Y);
            }
        }
        for (int i = 0; i < 8; i++) {
            pixels2[8][i] = new Pixel(PixelType.V.name() + (i + 1), PixelType.V);
            pixels2[9][i] = new Pixel(PixelType.V.name() + (i + 9), PixelType.V);
        }
        for (int i = 0; i < 8; i++) {
            pixels2[10][i] = new Pixel(PixelType.U.name() + (i + 1), PixelType.U);
            pixels2[11][i] = new Pixel(PixelType.U.name() + (i + 9), PixelType.U);
        }
    }
    
    static {
        pixels3 = new Pixel[18][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                pixels3[i][j] = new Pixel(PixelType.Y.name() + (i * 12 + j + 1), PixelType.Y);
            }
        }
        for (int i = 0; i < 12; i++) {
            pixels3[12][i] = new Pixel(PixelType.V.name() + (i + 1), PixelType.V);
            pixels3[13][i] = new Pixel(PixelType.V.name() + (i + 13), PixelType.V);
            pixels3[14][i] = new Pixel(PixelType.V.name() + (i + 25), PixelType.V);
        }
        for (int i = 0; i < 12; i++) {
            pixels3[15][i] = new Pixel(PixelType.U.name() + (i + 1), PixelType.U);
            pixels3[16][i] = new Pixel(PixelType.U.name() + (i + 13), PixelType.U);
            pixels3[17][i] = new Pixel(PixelType.U.name() + (i + 25), PixelType.U);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("原矩阵：");
        printMatrix(pixels);
        System.out.println("原矩阵：");
        printMatrix(pixels2);
        System.out.println("原矩阵：");
        printMatrix(pixels3);
        
        Object[][] matrixT = matrixTranspose(pixels);
        System.out.println("转置矩阵：");
        printMatrix(matrixT);
        
        Object[][] matrixT2 = matrixTranspose(pixels2);
        System.out.println("转置矩阵：");
        printMatrix(matrixT2);
        
        long startStamp = System.currentTimeMillis();
        Object[][] matrixT3 = matrixTranspose(pixels3);
        System.out.println("转置矩阵：");
        printMatrix(matrixT3);
        LogUtils.printTimeUsed(startStamp);
    }
    
    /**
     * 矩阵转置
     * 
     * @param matrix
     * @return
     */
    public static Object[][] matrixTranspose(Object[][] matrix) {
        if (null == matrix) {
            return null;
        }
        
        Object[][] matrixT = new Object[matrix[0].length][matrix.length];
        int raw, clo;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Pixel tmPixel = (Pixel) matrix[i][j];
                switch (tmPixel.getType()) {
                case Y:
                    clo = ((j + 1) % matrix[i].length) * 3 / 2 - 1;
                    clo = clo >= 0 ? clo : matrixT[i].length - 1;
                    matrixT[i][clo] = matrix[i][j];
                    break;

                case U:
                    raw = (i - 2 * matrix.length / 3 - matrix.length / 6) * 4 + (j / (matrix[i].length / 2)) * 2;
                    clo = (j + 1) % (matrix[i].length / 2) == 0 ? matrix[i].length / 2 : (j + 1) % (matrix[i].length / 2);
                    clo = 3 * clo - 2;
                    matrixT[raw][clo] = matrix[i][j];
                    break;
                    
                case V:
                    raw = (i - 2 * matrix.length / 3) * 4 + (j / (matrix[i].length / 2)) * 2 + 1;
                    clo = (j + 1) % (matrix[i].length / 2) == 0 ? matrix[i].length / 2 : (j + 1) % (matrix[i].length / 2);
                    clo = 3 * clo - 2;
                    matrixT[raw][clo] = matrix[i][j];
                    break;
                    
                default:
                    throw new AssertionError("枚举类型错误");
                }
            }
        }
        
        return matrixT;
    }
    
    private static void printMatrix(Object[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(((Pixel)matrix[i][j]).getName() + "\t");
            }
            System.out.println();
        }
    }
}
