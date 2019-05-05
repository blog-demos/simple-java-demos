package simple.java.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 * 工具类
 * </p>
 * 2016年1月14日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class WebUtils {
    
    public static void main(String[] args) {
        System.out.println(getALLLocalHostIP());
    }

    /**
     * 获得本地IP地址
     * @return
     */
    public static String getLocalHostIP() {
        String ip = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostAddress();
        } catch (UnknownHostException e) {
            ip = "";
        }
        
        return ip;
    }
    
    /**
     * 获取本机的主机名
     * @return
     */
    public static String getLocalHostName() {
        String name = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            name = address.getHostName();
        } catch (UnknownHostException e) {
            name = "";
        }
        
        return name;
    }
    
    /**
     * 获取本机所有的IP
     * @return
     */
    public static String[] getALLLocalHostIP() {
        String[] ipSet = null;
        String hostName = getLocalHostName();
        if (hostName.length() > 0) {
            try {
                InetAddress[] addresses = InetAddress.getAllByName(hostName);
                ipSet = new String[addresses.length];
                
                for (int i = 0; i < addresses.length; i++) {
                    ipSet[i] = addresses[i].getHostAddress();
                }
            } catch (UnknownHostException e) {
                ipSet = null;
            }
        }
        
        return ipSet;
    }
}
