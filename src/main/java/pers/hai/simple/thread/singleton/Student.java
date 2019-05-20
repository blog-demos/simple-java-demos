package pers.hai.simple.thread.singleton;

/**
 * <p>
 * 学生类
 * 被单例的实体
 * </p>
 * Create Date: 2016年4月6日
 * Last Modify: 2016年4月7日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.4
 */
public enum Student {

    INSTANCE;
    
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
