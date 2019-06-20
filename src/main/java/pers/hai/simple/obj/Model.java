package pers.hai.simple.obj;

import java.io.Serializable;

public class Model implements Serializable {

    private static final long serialVersionUID = -2743314291826647202L;

    public static final int CONST_1 = 12321;

    private int id;

    private byte[] bytes;
    
    private int[] array;
    
    private String name;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    
    public byte[] getBytes() {
        return bytes;
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }
    
    public int[] getArray() {
        return array;
    }
}
