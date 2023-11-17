package desavitsky.arrays;

import java.util.ArrayList;
import java.util.List;

// Min Stack
public class Task155 {

    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    static class MinStack {

        private final List<Long> stack2 = new ArrayList<>();

        public MinStack() {

        }

        public void push(int val) {
            if (stack2.isEmpty()) {
                long value = (((long) val) << 32) | (val & 0xffffffffL);
                stack2.add(value);
            } else {
                var previousMin = (int) (stack2.getLast().longValue());
                var newMin = Math.min(previousMin, val);
                long value = (((long) val) << 32) | (newMin & 0xffffffffL);
                stack2.add(value);
            }
        }


        public void pop() {
            stack2.removeLast();
        }

        public int top() {
            return (int)(stack2.getLast() >> 32);
        }

        public int getMin() {
            return(int)(stack2.getLast().longValue());
        }
    }
}

