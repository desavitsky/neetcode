package desavitsky.sliding;

import java.util.HashSet;

// 3. Longest Substring Without Repeating Characters
public class Task3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        var len = 0;

        var left = 0;
        var window = new HashSet<Character>();

        for (var i = 0; i < s.length(); i++) {
            while (!window.add(s.charAt(i))) {
                window.remove(s.charAt(left));
                left++;
            }
            len = Math.max(len, i - left + 1);
        }

        return len;
    }
}
