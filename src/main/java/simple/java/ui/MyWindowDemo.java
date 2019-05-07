package simple.java.ui;

//GUI ��ϰ  �г�ָ��Ŀ¼

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyWindowDemo {
    private Frame f;
    private TextField tf;
    private Button but;
    private TextArea ta;

    private Dialog d;
    private Label lab;
    private Button okBut;

    MyWindowDemo() {
        init();
    }

    public void init() {
        f = new Frame("my window");
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());

        tf = new TextField(63);

        but = new Button("button1");

        ta = new TextArea(25, 70);// ��������������

        d = new Dialog(f, "dialog1", true);
        d.setBounds(400, 200, 240, 150);
        d.setLayout(new FlowLayout());
        lab = new Label();
        okBut = new Button("ok button");

        f.add(tf);
        f.add(but);
        f.add(ta);

        d.add(lab);
        d.add(okBut);

        myEvent();

        f.setVisible(true);
    }

    private void myEvent() {
        okBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });

        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);// ��Ϊ���ɼ�
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    showDir();
            }
        });

        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDir();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void showDir() {
        String dirPath = tf.getText();

        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            ta.setText("");// ���ı�����Ϊ��
            String[] names = dir.list();
            for (String name : names) {
                // setText�÷���ֻ��������һ��Ŀ¼ ��Ϊ����ĸ���ǰ���
                // ta.setText(name + "\r\n");
                ta.append(name + "\r\n");// �������ı�׷�ӵ��ı����ĵ�ǰ�ı�
            }
        } else {
            String info = "ϵͳ�޷��ҵ�" + tf.getText() + "��������룡";
            lab.setText(info);
            d.setVisible(true);
        }
        tf.setText("");
    }

    public static void main(String[] args) {
        new MyWindowDemo();
    }

}