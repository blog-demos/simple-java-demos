package org.demo.file;

import java.io.File;
import java.io.IOException;

import org.core.utils.files.FileReadUtils;
import org.core.utils.files.FileSearchUtils;
import org.core.utils.files.FileWriteUtils;

/**
 * <p>
 * 合并文件
 * </p>
 * Create Date: 2016年5月3日
 * Last Modify: 2016年5月3日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class MergeFiles {

    static String outputPath = "F:/Temp/output/";
    static int size = 100;
    
    public static void main(String[] args) throws IOException {
        String inputPath = "F:/Temp/raw_data";
        
        
        @SuppressWarnings("deprecation")
        File[] files = FileSearchUtils.listFiles(inputPath);
        
        for (File file : files) {
            System.out.println(file);
            if (file.isDirectory()) {
                merage(file);
            }
        }
    }
    
    @SuppressWarnings("deprecation")
    public static void merage(File dir) throws IOException {
        File[] files = FileSearchUtils.listFiles(dir.toString());
        
        String fileName = outputPath + dir.getName();
        for (File file : files) {
            FileWriteUtils.appendFile(fileName, FileReadUtils.readToString(file.toString()) + "\n");
        }
    }
}
