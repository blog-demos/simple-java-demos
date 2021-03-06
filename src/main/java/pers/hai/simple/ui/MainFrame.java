package pers.hai.simple.ui;

import javax.swing.JFrame;

public class MainFrame {

    private JFrame jFrame = null;
    private CustomJPanel1 jPanel = null;
    
    private UpdateViewThread thread = null;
    
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.initEvent();
        frame.show();
        frame.updateView();
    }
    
    private void initEvent() {
        jFrame = new JFrame("Demo inside");
        jPanel = new CustomJPanel1();
        
        thread = new UpdateViewThread(jFrame);
    }
    
    private void show() {
        jFrame.add(jPanel);
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);
    }
    
    private void updateView() {
        thread.start();
    }
    
    class UpdateViewThread extends Thread {
        
        private JFrame jFrame = null;
        
        public UpdateViewThread(JFrame _jFrame) {
            jFrame = _jFrame;
        }
        
        @Override
        public void run() {
            try {
                do {
                    jPanel.modifyLabelText(String.valueOf(System.currentTimeMillis()));
                    jFrame.repaint();
                    Thread.sleep(1000);
                } while (true);
            } catch (InterruptedException ex) {
            }
        }
    }
}
