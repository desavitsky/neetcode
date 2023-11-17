package desavitsky.arrays;

import java.util.Stack;

//Baseball Game
public class Task682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(calPoints(new String[]{"1","C"}));
    }

    public static int calPoints(String[] operations) {

        var stack = new Stack<Integer>();
        for (String op : operations) {
            switch (op) {
                case String s when s.equals("C") && !stack.empty() -> stack.pop();
                case String s when s.equals("D") && !stack.empty() -> stack.push(stack.peek() * 2);
                case String s when s.equals("+") && stack.size() >= 2 -> {
                    var top = stack.pop();
                    var last = stack.peek() + top;
                    stack.push(top);
                    stack.push(last);
                }
                default -> stack.push(Integer.parseInt(op));
            }
        }
      var result = 0;
      while (!stack.empty()) {
          result += stack.pop();
      }
      return result;
    }
}
