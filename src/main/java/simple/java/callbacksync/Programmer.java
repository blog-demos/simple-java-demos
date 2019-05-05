package simple.java.callbacksync;

/**
 * <p>
 * 程序员
 * </p>
 * Create Date: 2016年4月22日
 * Last Modify: 2016年4月22日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Programmer {

    public Programmer() {
    }
    
    public void study(CallbackInterface callback) {
        new StudyThread(callback).start();
    }
    
    // --------------------------- Programmer 正在做的工作 ---------------------------
    
    class StudyThread extends Thread {
        
        CallbackInterface callback = null;
        
        public StudyThread(CallbackInterface _callback) {
            callback = _callback;
        }
        
        @Override
        public void run() {
            int result = 0;
            do {
                result++;
                System.out.println("第 " + result + " 次研究的结果");
            } while (!callback.check(result));
            
            System.out.println("调研任务结束");
        }
    }
}
