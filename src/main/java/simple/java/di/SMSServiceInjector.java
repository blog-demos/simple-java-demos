package simple.java.di;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:55 2019/05/05
 */
public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new Client(new SMSServiceImpl());
    }
}
