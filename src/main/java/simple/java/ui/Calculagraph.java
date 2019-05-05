package org.demo.ui;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Calculagraph {

    public static void main(String[] args) {
        JFrame frame = new JFrame("闹钟");
        JTextField time = new JTextField(30);
        JLabel timeLab = new JLabel("定时时间设定(请输入数字) ：");
        JTextArea event = new JTextArea(3, 10);
        // JTextField event = new JTextField(80);
        JLabel eventLab = new JLabel("事件提醒设定 ：");
        JButton but = new JButton("确 定");
        but.setBounds(300, 120, 80, 20);
        String picPath = "F:/Temp/" + File.separator + "0852193.jpg";
        File file = new File(picPath);
        InputStream input = null;
        byte b[] = new byte[(int) file.length()];
        try {
            input = new FileInputStream(file);
            input.read(b);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        Icon icon = new ImageIcon(b);
        JLabel lab = null;
        lab = new JLabel("", icon, JLabel.LEFT);
        Font fnt = new Font("Serief", Font.ITALIC + Font.BOLD, 28);
        lab.setFont(fnt);
        lab.setBackground(Color.YELLOW);
        lab.setForeground(Color.RED);
        timeLab.setBounds(200, 20, 170, 20);
        eventLab.setBounds(200, 50, 100, 20);
        time.setBounds(380, 20, 150, 25);
        event.setBounds(310, 50, 220, 50);
        frame.add(timeLab);
        frame.add(time);
        frame.add(eventLab);
        frame.add(event);
        frame.add(but);
        frame.add(lab);
        frame.setSize(600, 200);
        frame.setBackground(Color.WHITE);
        frame.setLocation(300, 200);
        frame.setLocation(300, 200);
        frame.setVisible(true);
    }
}