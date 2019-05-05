package simple.java.jsoup;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetImageRequest {

    private final static int ONE_SECOND = 1000;

    public static void main(String[] args) throws Exception {

        // 给定一条网络路径
        URL url = new URL(
                "https://malwareconfig.com/static/yaraRules/DarkComet.yar");
        HttpURLConnection huconn = (HttpURLConnection) url.openConnection(); // url用openConnection()打开连接
        huconn.setRequestMethod("GET"); // 设置请求命令将被发送到远程HTTP服务器

        huconn.setConnectTimeout(5 * ONE_SECOND); // 设置超时时间

        InputStream inStream = huconn.getInputStream(); // 通过输入流输入图片数据
        byte[] data = getNetImage(inStream); // 得到图片的二进制数据
        File image = new File("F:/Temp/DarkComet.yar");
        FileOutputStream outStream = new FileOutputStream(image);
        outStream.write(data);
        outStream.close();
    }

    public static byte[] getNetImage(InputStream inStream) throws Exception {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;

        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}