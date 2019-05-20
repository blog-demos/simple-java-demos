package pers.hai.simple.di;

import org.apache.log4j.Logger;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:46 2019/05/05
 */
public class EmailServiceImpl implements MessageService {

    private final Logger logger = Logger.getLogger(EmailServiceImpl.class);

    @Override
    public void sendMessage(String content, String receiver) {
        logger.info(String.format("通过邮件向%s发送消息:%s", receiver, content));
    }
}
