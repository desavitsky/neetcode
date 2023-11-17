package desavitsky.arrays;

import java.util.ArrayList;

//Valid Parentheses
public class Task20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("({[]})"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        var stack = new ArrayList<Character>(s.length());
        for (char cmd : s.toCharArray()) {
            if (stack.isEmpty()) stack.add(cmd);
            else if (cmd == '}' && stack.getLast() == '{') {
                stack.removeLast();
            } else if (cmd == ')' && stack.getLast() == '(') {
                stack.removeLast();
            } else if (cmd == ']' && stack.getLast() == '[') {
                stack.removeLast();
            } else stack.add(cmd);
        }
        return stack.isEmpty();
    }
}
