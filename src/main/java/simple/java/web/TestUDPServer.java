package simple.java.web;

import java.net.DatagramSocket;
import java.net.SocketException;

public class TestUDPServer {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            DatagramSocket server = new DatagramSocket(5632);
            byte[] bes = new byte[1024];
//            DatagramPacket
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
