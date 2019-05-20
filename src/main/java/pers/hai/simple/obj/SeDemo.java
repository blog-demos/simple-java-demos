package pers.hai.simple.obj;

import pers.hai.util.commons.obj.SerializationUtils;

public class SeDemo {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello StringBuffer.");
        SerializationUtils.writeObject(buffer, "F:/Temp/buffer.serio");
        StringBuffer readBuffer = (StringBuffer) SerializationUtils.readObject("F:/Temp/buffer.serio");
        System.out.println(readBuffer.toString());
    }
}
