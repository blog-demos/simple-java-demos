package pers.hai.simple.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomJPanel1 extends JPanel {

    private static final long serialVersionUID = -2920786419839388957L;

    private JLabel jLabel = null;
    
    private JButton jButton = null;
    
    public CustomJPanel1() {
        initEvent();
    }
    
    public void modifyLabelText(String label) {
        if (jLabel == null) {
            System.err.println("null JLabel");
            return;
        }
        
        jLabel.setText(label);
    }
    
    private void initEvent() {
        jLabel = new JLabel("Fire", JLabel.LEFT);
        jButton = new JButton("OK");
        
        setSize(500, 400);
        setLayout(new FlowLayout());
        add(jLabel);
        add(jButton);
        setVisible(true);
    }
}
