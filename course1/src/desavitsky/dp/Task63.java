package desavitsky.dp;

import java.util.Arrays;

// Unique Paths II
public class Task63 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        var m = obstacleGrid[0].length;

        var nextLine = new int[m];
        nextLine[m - 1] = 1;

        var current = obstacleGrid.length - 1;


        while (current >= 0) {
            var currentLine = new int[m];
            currentLine[m - 1] = (obstacleGrid[current][m - 1] == 1) ? 0 : nextLine[m - 1];

            for (var i = m - 2; i >= 0; i--) {
                if (obstacleGrid[current][i] == 1) currentLine[i] = 0;
                else currentLine[i] = currentLine[i + 1] + nextLine[i];
            }
            nextLine = currentLine;
            current--;
        }
        return nextLine[0];
    }
}
