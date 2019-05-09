package simple.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:20 2019/05/09
 */
public class TreeSetTest {

    @Test
    public void test1() {
        Set<String> set = new HashSet<>();
        set.add("20180101");
        set.add("20180102");
        set.add("20180103");
        set.add("20180104");
        set.add("20180105");

        Set<String> sortSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1); // 降序排列
            }
        });
        sortSet.addAll(set);
        System.out.println(set.toString());
        System.out.println(sortSet.toString());
    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<>();
        set.add("20180101");
        set.add("20180102");
        set.add("20180103");
        set.add("20180104");
        set.add("20180105");

        Set<String> sortSet = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        sortSet.addAll(set);
        System.out.println(set.toString());
        System.out.println(sortSet.toString());
    }

    @Test
    public void test3() {
        Set<String> set = new HashSet<>();
        set.add("20180101");
        set.add("20180102");
        set.add("20180103");
        set.add("20180104");
        set.add("20180105");

        Set<String> sortSet = new TreeSet<>(Comparator.reverseOrder());
        sortSet.addAll(set);
        System.out.println(set.toString());
        System.out.println(sortSet.toString());
    }

    @Test
    public void test4() {
        Set<String> set = new HashSet<>();
        set.add("20180101");
        set.add("20180102");
        set.add("20180103");
        set.add("20180104");
        set.add("20180105");

        set.stream().sorted(Comparator.reverseOrder());
        System.out.println(set.toString());
    }
}
