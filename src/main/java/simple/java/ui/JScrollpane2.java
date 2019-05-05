package simple.java.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JScrollpane2 implements ActionListener {
    JScrollPane scrollPane;

   @SuppressWarnings("deprecation")
public JScrollpane2(){
      JFrame f=new JFrame("JScrollPaneDemo");
      Container contentPane=f.getContentPane();
      
      JLabel label1=new JLabel(new ImageIcon("F:/IMG/20160104103735.jpg"));        
      JPanel panel1=new JPanel();
      panel1.add(label1);
      scrollPane=new JScrollPane();
      /*设置窗口显示组件为panel1
       */
      scrollPane.setViewportView(panel1);
      /*设置水平与垂直表头
       */
      scrollPane.setColumnHeaderView(new JLabel("水平表头"));
      scrollPane.setRowHeaderView(new JLabel("垂直表头"));
      /*设置scrollPane的边框凹陷立体边框。边框(Border)部份我们将在以后介绍。
       */
      scrollPane.setViewportBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
      /*设置scrollPane的边角图案，由于JScrollPane为矩形形状，因此就有4个位置来摆放边角(Corner)
       *组件，这4个地方分别是左上、左下、右上、右下，对应的参数分别如下:
       *JScrollPane.UPPER_LEFT_CORNER
       *JScrollPane.LOWER_LEFT_CORNER
       *JScrollPane.UPPER_RIGHT_CORNER
       *JScrollPane.LOWER_RIGHT_CORNER
       */
      scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,new JLabel(new ImageIcon("F:/IMG/20160105083431.jpg")));
      scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER,new JLabel(new ImageIcon("F:/IMG/20160105083431.jpg")));
      
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
      f.show();
      f.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
              System.exit(0);
           }
        }
      );            
   }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("显示水平滚动轴"))
            scrollPane.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        if (e.getActionCommand().equals("不要显示水平滚动轴"))
            scrollPane.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        if (e.getActionCommand().equals("适时显示水平滚动轴"))
            scrollPane.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.revalidate();// 重新显示JScrollPane形状。
    }

    public static void main(String[] args) {
        new JScrollpane2();
    }
}