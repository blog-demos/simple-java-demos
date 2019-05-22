package pers.hai.simple.obj;

import pers.hai.util.commons.obj.PersistenceUtils;

public class SeDemo {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello StringBuffer.");
        PersistenceUtils.writeObject(buffer, "F:/Temp/buffer.serio");
        StringBuffer readBuffer = (StringBuffer) PersistenceUtils.readObject("F:/Temp/buffer.serio");
        System.out.println(readBuffer.toString());
    }
}
