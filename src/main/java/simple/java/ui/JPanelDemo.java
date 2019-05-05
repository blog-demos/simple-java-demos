package simple.java.ui;

import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class JPanelDemo {

    private JFrame jFrame = null;
    private Button button = null;
    private TextField textField = null;
    
    public static void main(String[] args) {
        JPanelDemo demo = new JPanelDemo();
        demo.initEvent();
        demo.show();
        demo.addListener();
    }
    
    private void initEvent() {
        initJFrame();
        initButton();
        initTextField();
        
        setButtonActionListener(button);
    }
    
    private void show() {
        jFrame.setVisible(true);
        button.setVisible(true);
        textField.setVisible(true);
        
        jFrame.add(button);
        jFrame.add(textField);
    }
    
    private void addListener() {
        jFrame.addWindowListener(new WindowListenAdapter());
    }
    
    private void initJFrame() {
        jFrame = new JFrame("Hello GUI");
        jFrame.setSize(500, 300);
        jFrame.setLocation(200, 200);
    }
    
    private void initButton() {
        button = new Button("EXIT");
        button.setEnabled(true);
        button.setSize(60, 40);
        button.setLocation(250, 200);
    }
    
    private void initTextField() {
        textField = new TextField(20);
        textField.setFont(new Font("宋体", Font.BOLD, 20));
    }
    
    private void setButtonActionListener(Button _button) {
        _button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("EXITED");
                System.out.println("Get text: " + textField.getText());
                System.exit(0);
            }
        });
    }
}
