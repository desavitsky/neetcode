package desavitsky.search;

//  Search a 2D Matrix
public class Task74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        var l = 0;
        var r = matrix.length - 1;
        while (l <= r) {
            var mid = (l + r) / 2;
            var row = matrix[mid];
            if (row[0] > target) r = mid - 1;
            else if (row[row.length - 1] < target) l = mid + 1;
            else return searchRow(row, target);
        }
        return false;
    }

    private boolean searchRow(int[] row, int target) {
        var l = 0;
        var r = row.length - 1;
        while (l <= r) {
            var mid = (l + r) / 2;
            if (row[mid] > target) r = mid - 1;
            else if (row[mid] < target) l = mid + 1;
            else return true;
        }
        return false;
    }
}
