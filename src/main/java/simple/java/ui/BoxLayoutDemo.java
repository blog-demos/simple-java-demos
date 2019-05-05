package org.demo.ui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutDemo extends JFrame {

    private static final long serialVersionUID = -4553313242096575240L;

    private void testShow() {
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        JButton button1 = new JButton("1号按钮");
        JButton button2 = new JButton("2号按钮");
        JButton button3 = new JButton("3号按钮");
        JButton button4 = new JButton("4号按钮");
        JButton button5 = new JButton("5号按钮");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        add(panel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BoxLayoutDemo().testShow();
    }
}
