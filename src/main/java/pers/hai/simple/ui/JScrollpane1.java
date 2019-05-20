package pers.hai.simple.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JScrollpane1 implements ActionListener{
    
        JScrollPane scrollPane;
        public JScrollpane1(){
           JFrame f=new JFrame("JScrollpane1");
           Container contentPane=f.getContentPane();
           
           JLabel label1=new JLabel(new ImageIcon("F:/IMG/20160104103735.jpg"));
           JPanel panel1=new JPanel();
           panel1.add(label1);
           /*新增一个JScrollPane对象，并将panel1放入JScrollPane中，若pane1的组件大小在于窗口大小
            *大于窗口大小则会自动显示出ScrollBar.
            */
           scrollPane=new JScrollPane(panel1);
           
           JPanel panel2=new JPanel(new GridLayout(3,1));
           JButton b=new JButton("显示水平滚动轴");
           b.addActionListener(this);
           panel2.add(b);
           b=new JButton("不要显示水平滚动轴");
           b.addActionListener(this);
           panel2.add(b);
           b=new JButton("适时显示水平滚动轴");
           b.addActionListener(this);
           panel2.add(b);
           
           contentPane.add(panel2,BorderLayout.WEST);
           contentPane.add(scrollPane,BorderLayout.CENTER);
           
           f.setSize(new Dimension(350,220));
           f.setVisible(true);
           f.addWindowListener(new WindowAdapter(){
                @SuppressWarnings("unused")
                public void WindowClosing(WindowEvent e){
                   System.exit(0);
                }
           });
        }
        
        /*实现ActionListener界面，当用户按下"显示水平滚动轴"按钮时，则设置水平滚动轴参数为
         *JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS,若用户按下"不要显示水平滚动轴""按钮时，则设置
         *水平滚动轴参数为JScrollPane.HORIZONTAL_SCROLLBAR_NEVER，若用户按下"适时显示水平滚动轴"
         *时，则设置水平滚动轴参数为HORIZONTAL_SCROLLBAR_AS_NEEDED.
         */
        public void actionPerformed(ActionEvent e){
           if(e.getActionCommand().equals("显示水平滚动轴"))
              scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
           if(e.getActionCommand().equals("不要显示水平滚动轴"))
              scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
           if(e.getActionCommand().equals("适时显示水平滚动轴"))
              scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           scrollPane.revalidate();//重新显示JScrollPane形状。
        }
        public static void main(String[] args){
                new JScrollpane1();
    }
}