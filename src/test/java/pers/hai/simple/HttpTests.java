package pers.hai.simple;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-21 11:09
 * Last Modify: 2019-06-21
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class HttpTests {

    private final Logger logger = LoggerFactory.getLogger(HttpTests.class);

    @Test
    public void testHttpURLConnectionGet() {
        String httpurl = "http://xxx";

        HttpURLConnection conn = null;
        InputStream input = null;
        BufferedReader reader = null;
        String result = null; // 返回结果字符串

        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            conn = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            conn.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            conn.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            conn.setReadTimeout(60000);
            // 发送请求
            conn.connect();
            // 通过connection连接，获取输入流
            if (200 == conn.getResponseCode()) {
                input = conn.getInputStream();
                // 封装输入流is，并指定字符集
                reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
                // 存放数据
                StringBuilder sb = new StringBuilder();
                String temp;
                while (null != (temp = reader.readLine()))
                    sb.append(temp).append("\n");

                result = sb.toString();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // 关闭资源
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (null != input) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (null != conn)
                conn.disconnect(); // 关闭远程连接
        }

        logger.info("result = {}", result);
    }

    @Test
    public void testHttpURLConnectionPost() {
        String httpUrl = "http://xxx";
        String param = "key1=val1&key2=val2&key3=val3";

        HttpURLConnection conn = null;
        InputStream input = null;
        OutputStream output = null;
        BufferedReader reader = null;
        String result = null;

        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            conn = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            conn.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            conn.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            conn.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            conn.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            conn.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            conn.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            output = conn.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            output.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (200 == conn.getResponseCode()) {

                input = conn.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

                StringBuilder sb = new StringBuilder();
                String temp;
                // 循环遍历一行一行读取数据
                while ((temp = reader.readLine()) != null)
                    sb.append(temp).append("\n");

                result = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 断开与远程地址url的连接
            if (null != conn)
                conn.disconnect();

            if (null != result)
                logger.info("result = {}", result.trim());
        }
    }

    @Test
    public void testHttpClient3Get() {
        String url = "http://xxx";
        InputStream input = null;
        BufferedReader reader = null;
        String result = null;
        HttpClient httpClient = new HttpClient();
        // 设置http连接主机服务超时时间：15000毫秒
        // 先获取连接管理器对象，再获取参数对象,再进行参数的赋值
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建一个Get方法实例对象
        GetMethod getMethod = new GetMethod(url);
        // 设置get请求超时为60000毫秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        // 设置请求重试机制，默认重试次数：3次，参数设置为true，重试机制可用，false相反
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, true));
        try {
            // 执行Get方法
            int statusCode = httpClient.executeMethod(getMethod);
            // 判断返回码
            if (statusCode != HttpStatus.SC_OK)
                // 如果状态码返回的不是ok,说明失败了,打印错误信息
                System.err.println("Method faild: " + getMethod.getStatusLine());
            else {
                // 通过getMethod实例，获取远程的一个输入流
                input = getMethod.getResponseBodyAsStream();
                // 包装输入流
                reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

                StringBuilder sb = new StringBuilder();
                // 读取封装的输入流
                String temp;
                while (null != (temp = reader.readLine()))
                    sb.append(temp).append("\n");

                result = sb.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 释放连接
            getMethod.releaseConnection();
        }

        logger.info("result = {}", result);
    }

    @Test
    public void testHttpClient3Post() {
        String url = "http://xxx";
        Map<String, Object> paramMap = new HashMap<>(){{
            put("key1", 1);
            put("key2", 2);
            put("key3", "val3");
        }};

        // 获取输入流
        InputStream input = null;
        BufferedReader reader = null;
        String result = null;
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(url);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);

        NameValuePair[] nvp = null;
        // 判断参数map集合paramMap是否为空
        if (0 < paramMap.size()) {// 不为空
            // 创建键值参数对象数组，大小为参数的个数
            nvp = new NameValuePair[paramMap.size()];
            // 循环遍历参数集合map
            Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
            // 获取迭代器
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();

            int index = 0;
            while (iterator.hasNext()) {
                Map.Entry<String, Object> mapEntry = iterator.next();
                // 从mapEntry中获取key和value创建键值对象存放到数组中
                nvp[index] = new NameValuePair(mapEntry.getKey(),
                        new String(mapEntry.getValue().toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
                index++;
            }
        }
        // 判断nvp数组是否为空
        if (null != nvp && nvp.length > 0)
            // 将参数存放到requestBody对象中
            postMethod.setRequestBody(nvp);

        // 执行POST方法
        try {
            int statusCode = httpClient.executeMethod(postMethod);
            // 判断是否成功
            if (statusCode != HttpStatus.SC_OK)
                System.err.println("Method faild: " + postMethod.getStatusLine());

            // 获取远程返回的数据
            input = postMethod.getResponseBodyAsStream();
            // 封装输入流
            reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            String temp;
            while (null != (temp = reader.readLine()))
                sb.append(temp).append("\n");

            result = sb.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // 关闭资源
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (null != input) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            // 释放连接
            postMethod.releaseConnection();
        }

        logger.info("result = {}", result);
    }

    @Test
    public void testHttpClient4_5Get() {
        String url = "http://xxx";

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";

        try {
            // 通过址默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            // 创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);
            // 设置请求头信息，鉴权
            httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig
                    .custom()
                    .setConnectTimeout(35000)// 连接主机服务超时时间
                    .setConnectionRequestTimeout(35000)// 请求超时时间
                    .setSocketTimeout(60000)// 数据读取超时时间
                    .build();
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            // 通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            // 通过EntityUtils中的toString方法将结果转换为字符串
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        logger.info("result = {}", result);
    }

    @Test
    public void testHttpClient4_5Post() {
        String url = "http://xxx";
        Map<String, Object> paramMap = new HashMap<>(){{
            put("key1", 1);
            put("key2", 2);
            put("key3", "val3");
        }};

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // 封装post请求参数
        if (paramMap.size() > 0) {
            List<org.apache.http.NameValuePair> nvps = new ArrayList<>();
            // 通过map集成entrySet方法获取entity
            Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
            // 循环遍历，获取迭代器
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> mapEntry = iterator.next();
                nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
            }

            // 为httpPost设置封装好的请求参数
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        logger.info("result = {}", result);
    }
}
