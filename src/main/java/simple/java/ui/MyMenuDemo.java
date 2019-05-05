package simple.java.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyMenuDemo {
    
    private Frame f;
    private MenuBar bar;
    private Menu fileMenu,subMenu;
    private MenuItem closeItem,subItem1,subItem2;
    private MenuItem openItem,saveItem;

    //����򿪺ͱ���Ի���
    private FileDialog openDia,saveDia;

    //�����ı�����������򿪵�����
    private TextArea ta;

    private File file;

    MyMenuDemo()
    {
        init();
    }
        
    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,100,500,600);
        //f.setLayout(new FlowLayout());

        bar = new MenuBar();

        ta = new TextArea();

        fileMenu = new Menu("�ļ�");
        subMenu = new Menu("�Ӳ˵�");
            
        openItem = new MenuItem("��");
        saveItem = new MenuItem("����");
        subItem1 = new MenuItem("����Ŀ1");
        subItem2 = new MenuItem("����Ŀ2");
        closeItem = new MenuItem("�˳�");

        subMenu.add(subItem1);
        subMenu.add(subItem2);
        

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(subMenu);
        fileMenu.add(closeItem);
        bar.add(fileMenu);

        f.setMenuBar(bar);

        //Ĭ��ģʽΪ FileDialog.LOAD
        openDia = new FileDialog(f,"�ҵĴ�",FileDialog.LOAD);
        saveDia = new FileDialog(f,"�ҵı���",FileDialog.SAVE);

        f.add(ta);

        myEvent();

        f.setVisible(true);
    }

    private void myEvent()
    {
        saveItem.addActionListener(new ActionListener()
        {
            //���ñ����ļ��Ĺ���
            public void actionPerformed(ActionEvent e)
            {
                if(file == null)//�ļ������������ �����ļ�
                {
                    saveDia.setVisible(true);
                    String dirPath = saveDia.getDirectory();
                    String fileName = saveDia.getFile();

                    if(dirPath == null || fileName == null)
                        return ;
                    file = new File(dirPath,fileName);
                }
                
                try
                {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                
                    String text = ta.getText();

                    bufw.write(text);
                
                    bufw.close();
                }
                catch (IOException ex)
                {
                    throw new RuntimeException("�ļ�����ʧ�ܣ�");
                }
            }
        });

        openItem.addActionListener(new ActionListener()
        {
            //���ô��ļ�����
            public void actionPerformed(ActionEvent e)
            {
                openDia.setVisible(true);
                String dirPath = openDia.getDirectory();//��ȡ�ļ�·��
                String fileName = openDia.getFile();//��ȡ�ļ�����
                //System.out.println(dirPath +"++"+ fileName);
                
                //�����·�� �� Ŀ¼Ϊ�� �򷵻ؿ�
                if(dirPath == null || fileName == null)
                        return ;

                ta.setText("");//����ı�

                file = new File(dirPath,fileName);
                
                try
                {
                        BufferedReader bufr = new BufferedReader(new FileReader(file));
                        
                        String line = null;

                        while( (line = bufr.readLine())!= null)
                        {
                            ta.append(line +"\r\n");
                        }
                        bufr.close();
                }
                catch (IOException ex)
                {
                    throw new RuntimeException("�ļ���ȡʧ�ܣ�");
                }

                

            }
        });

        closeItem.addActionListener(new ActionListener()
        {
            //�����˳�����
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    public static void main(String []args)
    {
     new MyMenuDemo();
    }
}