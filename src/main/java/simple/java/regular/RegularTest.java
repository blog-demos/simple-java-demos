package simple.java.regular;

import org.core.utils.str.StringUtils;

public class RegularTest {

    public static void main(String[] args) {
        System.out.println(StringUtils.RegexUtils.isSub("中国", "^[\\u4e00-\\u9fa5]{0,}$"));
    }
}
