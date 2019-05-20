package pers.hai.simple.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 混淆文件
 * 让文件被百度网盘无法识别
 * </p>
 * 2016年2月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class ConfusedFile {

    private static final int LIMIT = 1024;
    
    /**
     * 混淆目标文件
     * 
     * @param source
     *      原始文件
     * @throws IOException
     *      读写异常
     */
    public static final void confuse(String source) throws IOException {
        String target = "" + source;
        copyFileByBuffer(source, target);
        modifyFile(target, LIMIT);
    }
    
    /*
     * 修改文件的数据
     * 
     * @param target
     *      目标文件
     * @param limit
     *      前limit个字节
     * @throws IOException 
     */
    private static final void modifyFile(String target, int limit) throws IOException {
        byte[] bytes = new byte[limit];
        RandomAccessFile rf = new RandomAccessFile(target, "rw");
        // read & modify
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (rf.readByte() ^ 0xFF);
        }
        rf.close();
        
        // write
        rf = new RandomAccessFile(target, "rw");
        rf.write(bytes);
        rf.close();
    }

    /*
     * 复制文件
     * 
     * @param source
     *      原文件
     * @param target
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    private static final void copyFileByBuffer(String source, String target)
            throws IOException {
        FileInputStream inStream = new FileInputStream(new File(source));
        FileOutputStream outStream = new FileOutputStream(new File(target));
        FileChannel in = inStream.getChannel();
        FileChannel out = outStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

        inStream.close();
        in.close();
        outStream.close();
        out.close();
    }
}
