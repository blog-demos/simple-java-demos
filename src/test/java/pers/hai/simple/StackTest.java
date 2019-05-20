package pers.hai.simple;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author: Q-WHai
 * @Date: Created in 14:45 2019/05/06
 */
public class StackTest {

    private final Logger logger = Logger.getLogger(StackTest.class);

    @Test
    public void test1() {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");
        logger.info(stack.size());
    }

    @Test
    public void test2() {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");

        String peek1 = stack.peek();
        logger.info(peek1);
        String peek2 = stack.peek();
        logger.info(peek2);
        logger.info(stack.size());
    }

    @Test
    public void test3() {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");

        String pop = stack.pop();
        logger.info(pop);
        logger.info(stack.size());
    }

    @Test
    public void test4() {
        Stack<Iterator<String>> stack = new Stack<>();
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        stack.push(strings.iterator());

        Iterator<String> iterator = stack.peek();
        logger.info(iterator.next());
        Iterator<String> iterator2 = stack.peek();
        logger.info(iterator2.next());
    }
}
