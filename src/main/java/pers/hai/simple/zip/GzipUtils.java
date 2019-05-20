package pers.hai.simple.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class GzipUtils {

    public static void main(String[] args) {
        gzip("F:/Temp/CShape/tmp.tar.gz", "F:/Temp/CShape/aaa/");
    }
    
    private static void gzip(String gzPath, String topath) {
        try {
            int nnumber;

            FileInputStream fin = new FileInputStream(gzPath);

            MultiMemberGZIPInputStream MmGz = new MultiMemberGZIPInputStream(fin);
            FileOutputStream fout = new FileOutputStream(topath);

            byte[] buf = new byte[1024];

            nnumber = MmGz.read(buf, 0, buf.length);

            while (nnumber != -1) {
                fout.write(buf, 0, nnumber);
                nnumber = MmGz.read(buf, 0, buf.length);
            }
            
            MmGz.close();
            fout.close();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
