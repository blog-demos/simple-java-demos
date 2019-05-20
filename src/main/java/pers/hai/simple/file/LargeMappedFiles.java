package pers.hai.simple.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {

    static int length = 0x8FFFFFF; // 128 Mb

    public static void main(String[] args) throws Exception {
        // write();
        // reader();
         copy("F:/a.iso", "F:/a-copy.iso");
    }

    @SuppressWarnings("unused")
    private static void write() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("F:/a.txt",
                "rw");

        MappedByteBuffer out = randomAccessFile.getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);

        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }

        System.out.println("Finished writing");

        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char) out.get(i));
        }

        randomAccessFile.close();
    }

    @SuppressWarnings("unused")
    private static void reader() throws IOException {
        length = 0xFF;

        RandomAccessFile randomAccessFile = new RandomAccessFile("F:/b.txt",
                "r");

        MappedByteBuffer out = randomAccessFile.getChannel()
                .map(FileChannel.MapMode.READ_ONLY, 0, length);

        for (int i = 0; i < length; i++) {
            System.out.println(out.get());
        }

        System.out.println("Finished writing");

        randomAccessFile.close();
    }

    private static void copy(String sourcePath, String targetPath) throws IOException {
        RandomAccessFile readFile = new RandomAccessFile(sourcePath, "r");
        RandomAccessFile writeFile = new RandomAccessFile(targetPath, "rw");

        long fileLength = readFile.length();
        
        MappedByteBuffer in = readFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
        MappedByteBuffer out = writeFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLength);

        for (int i = 0; i < fileLength; i++) {
            out.put(in.get());
        }

        System.out.println("Finished writing");

        readFile.close();
        writeFile.close();
    }
}