package simple.java.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DemoStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");
        System.out.println(stack);
        
        String peek1 = stack.peek();
        System.out.println(peek1);
        String peek2 = stack.peek();
        System.out.println(peek2);
        System.out.println(stack);
        
        stack.pop();
        System.out.println(stack);
        
        Stack<Iterator<String>> stack2 = new Stack<>();
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        stack2.push(strings.iterator());
        
        Iterator<String> iterator = stack2.peek();
        System.out.println(iterator.next());
        Iterator<String> iterator2 = stack2.peek();
        System.out.println(iterator2.next());
    }
}
