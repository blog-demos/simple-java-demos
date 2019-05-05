package simple.java.web;

import simple.java.web.bean.Person;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestTCPClient {

    public static void main(String[] args) {
//        Socket client = null;
//        PrintStream stream = null;
//        try {
//            client = new Socket("localhost", 5632);
//            System.out.println("ok");
//            
//            stream = new PrintStream(client.getOutputStream());
//            stream.print("你好");
//            
//            client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        startClient("localhost", 5632);
    }
    
    private static void startClient(String host, int port) {
        try {
            Socket client = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            Person person = new Person();
            person.setName("小明");
            person.setAge(25);
            oos.writeObject(person);
            oos.flush();
            
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
