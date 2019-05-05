package simple.java.vol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.core.utils.files.FileReadUtils;
import org.core.utils.str.StringUtils;

public class VolFileCheckDemo {

    static final String FOLDER = "C:\\Users\\Naga\\Desktop\\work study\\Volatility\\2016-01-20\\";
    
    public static void main(String[] args) throws IOException {
        
        List<String> list = FileReadUtils.readLines(FOLDER + "pslist.txt");
        List<String> ps1 = new ArrayList<>();
        for (String line : list) {
            String[] words = line.split(" ");
            int first = 0;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals(" ") && !StringUtils.isEmpty(words[i])) {
                    first++;
                    if (first == 2) {
                        ps1.add(words[i]);
                        break;
                    }
                }
            }
        }
        
        // 
        list.clear();
        list = FileReadUtils.readLines(FOLDER + "psscan.txt");
        List<String> ps2 = new ArrayList<>();
        for (String line : list) {
            String[] words = line.split(" ");
            int first = 0;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals(" ") && !StringUtils.isEmpty(words[i])) {
                    first++;
                    if (first == 2) {
//                        System.out.println(words[i]);
                        ps2.add(words[i]);
                        break;
                    }
                }
            }
        }
        
        List<String> ps3 = new ArrayList<>();
        for (String app : ps2) {
            if (!ps1.contains(app)) {
                ps3.add(app);
            }
        }
        
        for (String app : ps3) {
            System.out.println(app);
        }
    }
}
