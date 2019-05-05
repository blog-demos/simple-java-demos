package simple.java.web;

import simple.java.web.bean.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPServer {

    public static void main(String[] args) {
        startServer(5632);
//        ServerSocket server = null;
//        try {
//            server = new ServerSocket(5632);
//            Socket socket = server.accept();
//            socket.setSoTimeout(3000);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(reader.readLine());
//            
//            reader.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    private static void startServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Person person = (Person) ois.readObject();
            System.out.println(person);
            ois.close();
            socket.close();
            server.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
