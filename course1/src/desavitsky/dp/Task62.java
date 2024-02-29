package desavitsky.dp;

import java.util.Arrays;

// Unique Paths
public class Task62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {

        var nextLine = new int[m];

        var current = n - 1;

        while (current >= 0) {
            var currentLine = new int[m];
            currentLine[m - 1] = 1;
            for (var i = m - 2; i >= 0; i--) {
                currentLine[i] = currentLine[i + 1] + nextLine[i];
            }
            nextLine = currentLine;
            current--;
            System.out.println(Arrays.toString(nextLine));
        }
        return nextLine[0];
    }
}
