package simple.java.log4j;

import org.apache.log4j.Level;

/**
 * @Author: Q-WHai
 * @Date: Created in 12:56 2019/05/06
 */
public class CustomLogLevel extends Level {

    private static final long serialVersionUID = 1L;

    public CustomLogLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }
}
