package simple.java.file;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.core.utils.files.FileUtils;
import org.core.utils.str.StringUtils;
import org.core.utils.time.TimeUtils;

/**
 * <p>
 * 创建一年所有日期对应的文件
 * </p>
 * 2016年2月17日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class CalendarFileDemo {

    private static final String BASE_PATH = "E:/company/work-log/";
    private static final String[] WEEK = {"六", "日", "一", "二", "三", "四", "五", "六"};
    private static final int DAYS_OF_YEAR = 356;
    
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        @SuppressWarnings("deprecation")
        Date d = new Date(2016-1900, 0, 1);
        calendar.setTime(d);
        
        int day_index = 0;
        while((day_index++) < DAYS_OF_YEAR) {
            createFile(calendar);
            calendar = TimeUtils.CalendarUtils.afterSomeDays(calendar, 1);
        }
    }
    
    /*
     * 是否是周末
     * 
     * @param week
     *      周几
     * @return
     *      是否是周末
     */
    private static final boolean isWeekendDay(int week) {
        if (week == 1 || week == 7) {
            return true;
        }
        
        return false;
    }

    /*
     * 将某一个日期转成一个文件
     * 
     * @param calendar
     *      某一日期
     */
    private static final void createFile(Calendar calendar) {
        String year = StringUtils.formatIntegerString(calendar.get(Calendar.YEAR), "#0000");
        String month = StringUtils.formatIntegerString(calendar.get(Calendar.MONTH) + 1, "#00");
        String date = StringUtils.formatIntegerString(calendar.get(Calendar.DATE), "#00");
        int week = TimeUtils.CalendarUtils.getWeek(calendar);

        if (isWeekendDay(week)) {
            return;
        }
        
        String folder = BASE_PATH + year + "-" + month;
        String fileName = year + "-" + month + "-" + date + " " + WEEK[week] + ".txt";
        
        try {
            FileUtils.createFullFile(folder + "/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
