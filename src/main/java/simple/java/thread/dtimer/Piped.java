package simple.java.thread.dtimer;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

    static class Print implements Runnable {
        private PipedReader in;
        
        public Print(PipedReader in) {
            this.in = in;
        }
        
        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char)receive);
                }
                Thread.sleep(1000);
            } catch (InterruptedException | IOException e) {
                System.err.println(e);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "printThread");
        printThread.start();
        
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            out.close();
        }
    }
}
