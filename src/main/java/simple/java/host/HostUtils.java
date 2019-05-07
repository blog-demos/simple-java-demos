package simple.java.host;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description TODO
 * @Author: Q-WHai
 * @Date: Created in 14:15 2019/05/06
 */
public class HostUtils {

    /**
     * 获得本地IP地址
     * @return
     */
    public static String getLocalHostIP() {
        String ip;
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
        String name;
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
