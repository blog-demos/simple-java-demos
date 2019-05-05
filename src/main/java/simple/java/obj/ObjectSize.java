package simple.java.obj;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSize {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        
        
        byte[] bytes = {0x10, 0x65, 0x45, 0x23, 0x2};
        int[] array = {2, 3, 4, 5, 6, 7};
        Model model = new Model();
        model.setBytes(bytes);
        model.setArray(array);
        
        os.writeObject(model);
        os.flush();
        System.out.println(bs.size());
    }
}
