package pers.hai.simple.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pers.hai.util.commons.logs.LogUtils;
import pers.hai.util.commons.web.impl.WebHTMLParserImpl;
import pers.hai.util.commons.web.poke.HTMLParserUtils;

public class JsoupDemo {

    public static void main(String[] args) {
        JsoupDemo demo = new JsoupDemo();
        demo.parser();
        demo.parserRaw();
    }
    
    private void parserRaw() {
        long startStamp = System.currentTimeMillis();
        
        
        
        try {
            Document document = Jsoup.connect("http://www.baidu.com/")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0")
                    .get();
            
            document = Jsoup.parse("http://www.baidu.com/");
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        for (int i = 0; i < 10; i++) {
        }
        
        LogUtils.printTimeUsed(startStamp);
        LogUtils.printRuntimeInfo();
    }
    
    private void parser() {
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            parserCeil();
        }
        
        LogUtils.printTimeUsed(startStamp);
        LogUtils.printRuntimeInfo();
    }
    
    private void parserCeil() {
        HTMLParserUtils parser = new HTMLParserUtils(new WebHTMLParserImpl());
        try {
            parser.requestHTML("http://www.baidu.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
