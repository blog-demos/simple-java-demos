package pers.hai.simple.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>
 * 窗口监听器
 * </p>
 * 2016年1月8日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
class WindowListenAdapter extends WindowAdapter {
    
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("I am opened.");
//        super.windowOpened(e);
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("I am closing.");
        super.windowClosing(e);
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("I am closed.");
        super.windowClosed(e);
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("I am activated.");
//        super.windowActivated(e);
    }
}
