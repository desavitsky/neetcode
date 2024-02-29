package desavitsky.prefix_sums;

import java.util.Arrays;

// 304. Range Sum Query 2D - Immutable
public class Task304 {

    public static void main(String[] args) {
//        int[][] mtx = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };
        int[][] mtx = {
                {7, 7, 0},
                {-4,-7,7},
                {-4,0,-2},
                {-8,-5,6}
        };
        var numM = new NumMatrix(mtx);
        var numOld = new NumMatrixOld(mtx);
//        System.out.println(numM.sumRegion(2, 1, 4, 3));
//        System.out.println(numOld.sumRegion(2, 1, 4, 3));
//        System.out.println(numM.sumRegion(1, 1, 2, 2));
//        System.out.println(numOld.sumRegion(1, 1, 2, 2));
//        System.out.println(numM.sumRegion(1, 2, 2, 4));
//        System.out.println(numOld.sumRegion(1, 2, 2, 4));
        System.out.println(numM.sumRegion(1,0,2,2));
        System.out.println(numOld.sumRegion(1,0,2,2));
        System.out.println(numM.sumRegion(1,0,2,2));
        System.out.println(numOld.sumRegion(1,0,2,2));
    }

}

class NumMatrixOld {

    private final int[][] prefixes;

    public NumMatrixOld(int[][] matrix) {
        var prefixes = new int[matrix.length][];
        var rowLength = matrix[0].length;
        for (var i = 0; i < matrix.length; i++) {
            var rowPrefix = new int[rowLength];
            rowPrefix[0] = matrix[i][0];
            for (var j = 1; j < rowLength; j++) {
                rowPrefix[j] = matrix[i][j] + rowPrefix[j - 1];
            }
            prefixes[i] = rowPrefix;
        }
        this.prefixes = prefixes;
        System.out.println(Arrays.deepToString(prefixes));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        var sum = 0;
        for (var i = row1; i <= row2; i++) {
            var prefixRight = prefixes[i][col2];
            var prefixLeft = col1 > 0 ? prefixes[i][col1 - 1] : 0;
            sum += (prefixRight - prefixLeft);
        }
        return sum;
    }
}

class NumMatrix {

    private final int[][] prefixes;

    public NumMatrix(int[][] matrix) {
        var rowLength = matrix[0].length;
        var prefixes = new int[matrix.length][rowLength];
        var prev = new int[rowLength];
        for (var i = 0; i < matrix.length; i++) {
            var rowSum = 0;
            for (var j = 0; j < rowLength; j++) {
                rowSum += matrix[i][j];
                prefixes[i][j] = prev[j] + rowSum;
            }
            prev = prefixes[i];
        }
        this.prefixes = prefixes;
        System.out.println(Arrays.deepToString(prefixes));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            System.out.println(STR."COND 0: \{prefixes[row2][col2]}");
            return prefixes[row2][col2];
        } else if (row1 == 0) {
            System.out.println(STR."COND 1: \{prefixes[row2][col2]} - \{prefixes[row2][col1 - 1]}");
            return prefixes[row2][col2] - prefixes[row2][col1 - 1];
        } else if (col1 == 0) {
            System.out.println(STR."COND 2: \{prefixes[row2][col2]} - \{prefixes[row1 - 1][col2]}");
            return prefixes[row2][col2] - prefixes[row1 - 1][col2];
        } else {
            System.out.println(STR."COND 3: \{prefixes[row2][col2]} - \{prefixes[row2 - 1][col2]} - \{prefixes[row2][col2 - 1]} + \{prefixes[row1 - 1][col1 - 1]}");
            return prefixes[row2][col2] - prefixes[row1 - 1][col2] - prefixes[row2][col1 - 1] + prefixes[row1 - 1][col1 - 1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
