package pers.hai.simple.di;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:54 2019/05/05
 */
public class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new Client(new EmailServiceImpl());
    }
}
