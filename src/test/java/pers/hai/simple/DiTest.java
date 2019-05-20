package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.di.*;
import simple.java.di.*;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:53 2019/05/05
 */
public class DiTest {

    // 基于构造器注入
    @Test
    public void test1() {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        MessageServiceInjector injector;
        Consumer app;

        // Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);
    }

    // 基于构造器注入
    @Test
    public void test2() {
        String msg = "Hi Pankaj";
        String phone = "4088888888";
        MessageServiceInjector injector;
        Consumer app;

        // Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }

    // 基于Setter注入
    @Test
    public void test3() {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";

        MessageServiceInjector injector = new MessageServiceInjector() {
            @Override
            public Consumer getConsumer() {
                Client2 client = new Client2();
                client.setService(new EmailServiceImpl());
                return client;
            }
        };
        Consumer app = injector.getConsumer();
        app.processMessages(msg, email);
    }

    // 基于Setter注入
    @Test
    public void test4() {
        String msg = "Hi Pankaj";
        String phone = "4088888888";

        MessageServiceInjector injector = new MessageServiceInjector() {
            @Override
            public Consumer getConsumer() {
                Client2 client = new Client2();
                client.setService(new SMSServiceImpl());
                return client;
            }
        };
        Consumer app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
}
