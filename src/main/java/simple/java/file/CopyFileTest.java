package simple.java.file;

import java.io.IOException;

import org.core.utils.files.FileUtils;
import org.core.utils.logs.LogUtils;

public class CopyFileTest {

    static final String SOURCE_FILE = "F:/a.iso";
    
    public static void main(String[] args) {
        testCopyFileByBuffer();
        testCopyFileByTransfer();
        testCopyFileByMapped();
    }
    
    private static void testCopyFileByBuffer() {
        long startStamp = System.currentTimeMillis();
        try {
            FileUtils.copyFileByBuffer(SOURCE_FILE, "F:/a-copy-buffer.iso");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogUtils.printTimeUsed("Buffer", startStamp);
    }
    
    private static void testCopyFileByTransfer() {
        long startStamp = System.currentTimeMillis();
        try {
            FileUtils.copyFileByTransfer(SOURCE_FILE, "F:/a-copy-transfer.iso");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogUtils.printTimeUsed("Transfer", startStamp);
    }
    
    private static void testCopyFileByMapped() {
        long startStamp = System.currentTimeMillis();
        try {
            FileUtils.copyFileByMapped(SOURCE_FILE, "F:/a-copy-mapped.iso");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogUtils.printTimeUsed("Mapped", startStamp);
    }
}
