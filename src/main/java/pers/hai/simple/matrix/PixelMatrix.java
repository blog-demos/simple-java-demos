package pers.hai.simple.matrix;

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
    
    static {
        pixels = new Pixel[6][4];
        pixels[0][0] = new Pixel("Y1", PixelType.Y);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                pixels[i][j] = new Pixel(PixelType.Y.name() + (i * 4 + j + 1), PixelType.Y);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            pixels[4][i] = new Pixel(PixelType.V.name() + (i + 1), PixelType.V);
        }
        
        for (int i = 0; i < 4; i++) {
            pixels[5][i] = new Pixel(PixelType.U.name() + (i + 1), PixelType.V);
        }
    }
    
    public static void main(String[] args) {
        Object[][] matrixT = matrixTranspose(pixels);
        
        System.out.println("原矩阵：");
        printMatrix(pixels);
        System.out.println("转置矩阵：");
        printMatrix(matrixT);
        
        matrixTransposePart(matrixT, 4);
        System.out.println("转置矩阵：");
        printMatrix(matrixT);
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
        
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixT[i][j] = matrix[j][i];
            }
        }
        
        return matrixT;
    }
    
    /**
     * 矩阵转置
     * 
     * @param matrix
     * @param raw
     */
    public static void matrixTransposePart(Object[][] matrix, int raw) {
        if (null == matrix) {
            return;
        }
        
        for (int i = 0; i < raw; i++) {
            for (int j = i + 1; j < raw; j++) {
                if (i == j) {
                    continue;
                }
                
                Pixel firstPixel = (Pixel)matrix[i][j];
                Pixel secondPixel = (Pixel)matrix[j][i];
                
                Pixel swapPixel = new Pixel(firstPixel.getName(), firstPixel.getType());
                firstPixel.setName(secondPixel.getName());
                firstPixel.setType(secondPixel.getType());
                
                secondPixel.setName(swapPixel.getName());
                secondPixel.setType(swapPixel.getType());
            }
        }
    }
    
    private static void printMatrix(Object[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(((Pixel)matrix[i][j]).getName() + "\t");
            }
            System.out.println();
        }
    }
    
    public static byte[] YV12toYUV420PackedPlanar(byte[] input, byte[] output,
            int width, int height) {
        /*
         * YYYYYYYY VVUU to YYYYYYYY UVUV
         */
        long time = System.currentTimeMillis();
        final int frameSize = width * height;
        final int frameSizeAll = frameSize * 3 / 2;
        int y = 0, u = 0, v = 0;
        int frameSizeOf4 = frameSize / 4;
        byte[] inputU = new byte[frameSizeOf4];
        byte[] inputV = new byte[frameSizeOf4];
        System.arraycopy(input, frameSize + frameSizeOf4, inputU, 0, frameSizeOf4);
        System.arraycopy(input, frameSize, inputV, 0, frameSizeOf4);
        for (int i = 0; i < frameSizeAll; i++) {
            if ((int) (i / width) % 2 == 0) {
                if (i % 3 == 1) {
                    output[i] = inputU[u];
                    u++;
                } else {
                    output[i] = input[y];
                    y++;
                }
            } else {
                if (i % 3 == 1) {
                    output[i] = inputV[v];
                    v++;
                } else {
                    output[i] = input[y];
                    y++;
                }
            }

        }
        System.out.println("input的长度间隔:" + input.length);
        System.out.println("width的长度间隔:" + width);
        System.out.println("height的长度间隔:" + height);
        System.out.println("y的长度间隔:" + y);
        System.out.println("u的长度间隔:" + u);
        System.out.println("v的长度间隔:" + v);
        System.out.println("时间间隔：" + (System.currentTimeMillis() - time));

        return output;
    }
}
