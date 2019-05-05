package simple.java.file;

import java.io.File;
import java.io.IOException;

import org.core.utils.files.FileReadUtils;
import org.core.utils.files.FileSearchUtils;

public class FileSeachDemo {

    public static void main(String[] args) throws IOException {
        // MD5
        String path = "F:/Temp/Douyu/classes-dex2jar.air.src";
        finding(path);
    }
    
    private static void finding(String path) throws IOException {
        File[] subFiles = FileSearchUtils.getAllSubFiles(path);
        
        for (File subFile : subFiles) {
            if (subFile.isDirectory()) {
                finding(subFile.getPath());
            } else {
                checking(subFile.getPath());
            }
        }
    }
    
    private static void checking(String fileFullName) throws IOException {
        String fileContent = FileReadUtils.readToString(fileFullName);
        if (fileContent.toLowerCase().contains("az")) {
            System.out.println(fileFullName);
        }
    }
}
