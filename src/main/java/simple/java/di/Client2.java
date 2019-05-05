package simple.java.di;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:21 2019/05/05
 */
public class Client2 implements Consumer {

    private MessageService service;

    public Client2() { }

    public void setService(MessageService service) {
        this.service = service;
    }

    @Override
    public void processMessages(String content, String receiver) {
        if (null == service) return;

        service.sendMessage(content, receiver);
    }
}
