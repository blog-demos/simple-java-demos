package pers.hai.simple.di;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:51 2019/05/05
 */
public class Client implements Consumer {

    private MessageService service;

    Client(MessageService service) {
        this.service = service;
    }

    @Override
    public void processMessages(String content, String receiver) {
        if (null == service) return;

        service.sendMessage(content, receiver);
    }
}
