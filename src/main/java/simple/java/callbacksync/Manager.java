package simple.java.callbacksync;

/**
 * <p>
 * 项目经理
 * </p>
 * Create Date: 2016年4月22日
 * Last Modify: 2016年4月22日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Manager implements CallbackInterface {

    private Programmer programmer = null;
    
    public Manager(Programmer _programmer) {
        this.programmer = _programmer;
    }
    
    /**
     * 用于 Boss 下达的委托
     */
    public void entrust() {
        arrange();
    }
    
    // 进行安排下属进行 study 工作
    private void arrange() {
        System.out.println("Manager 正在为 Programmer 安排工作");
        programmer.study(Manager.this);
        System.out.println("为 Programmer 安排工作已经完成，Manager 做其他的事情去了。");
    }
    
    @Override
    public boolean check(int result) {
        if (result == 5) {
            return true;
        }
        return false;
    }

}
