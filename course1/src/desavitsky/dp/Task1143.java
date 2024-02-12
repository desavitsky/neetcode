package desavitsky.dp;

public class Task1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        var next = new int[text2.length() + 1];
        for (var i = text1.length() - 1; i >= 0; i--) {
            var current = new int[text2.length() + 1];
            for (var j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    current[j] = next[j + 1] + 1;
                } else {
                    current[j] = Math.max(current[j + 1], next[j]);
                }
            }
            next = current;
        }
        return next[0];
    }
}
