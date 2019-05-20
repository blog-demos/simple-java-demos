package pers.hai.simple.hash;

import pers.hai.util.commons.obj.SerializationUtils;

public class HashClient {

    public static void main(String[] args) {
        
        HashObject object = new HashObject();
        object.add("ABC", 3);
        SerializationUtils.writeObject(object, "F:/Temp/hash.obj");
        
        HashObject readObject = (HashObject) SerializationUtils.readObject("F:/Temp/hash.obj");
        
        boolean b1 = readObject.contains("baidu");
        boolean b2 = readObject.contains("google");
        boolean b3 = readObject.contains("apple");
        boolean b4 = readObject.contains("ABC");
        boolean b5 = readObject.contains("ABCD");
        
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
    }
}
