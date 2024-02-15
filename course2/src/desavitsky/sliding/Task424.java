package desavitsky.sliding;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 424. Longest Repeating Character Replacement
public class Task424 {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement2(String s, int k) {
        var symbols = new HashMap<Character, Integer>();
        var window = 0;
        var max = 0;
        var maxF = 0;
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            var current = symbols.getOrDefault(ch, 0);
            symbols.put(ch, current + 1);
            window++;
            maxF = Math.max(maxF, current + 1);
            while (window - maxF > k) {
                var ch2 = s.charAt(i - window + 1);
                symbols.computeIfPresent(ch2, (key, value) -> value - 1);
                window--;
            }
            max = Math.max(max, window);
        }
        return max;
    }

    public static int characterReplacement(String s, int k) {
        var symbols = new int[26];
        var window = 0;
        var max = 0;

        for (var i = 0; i < s.length(); i++) {
            int position = s.charAt(i) - 'A';
            symbols[position] = symbols[position] + 1;
            window++;
            while (window - topLength(symbols) > k) {
                var positionToRemove = s.charAt(i - window + 1) - 'A';
                symbols[positionToRemove] = symbols[positionToRemove] - 1;
                window--;
            }

            max = Math.max(max, window);
        }
        return max;
    }

    private static int topLength(int[] symbols) {
        var max = 0;
        for (var count : symbols) {
            max = Math.max(count, max);
        }
        return max;
    }
}
