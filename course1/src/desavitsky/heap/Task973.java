package desavitsky.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task973 {

    public static void main(String[] args) {
        var input = new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4}
        };
        var input1 = new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2},
                new int[]{2, -2}
        };
        System.out.println(Arrays.deepToString(kClosest(input, 2)));
        System.out.println(Arrays.deepToString(kClosest2(input1, 2)));
        System.out.println(Arrays.deepToString(input1));
    }

    private record Point(int x, int y) {
        public int sqrD() {
            return (int) (Math.pow(x, 2) + Math.pow(y, 2));
        }
    }

    // heap
    public static int[][] kClosest(int[][] points, int k) {
        Queue<Point> heap = new PriorityQueue<>(Comparator.comparingInt(Point::sqrD).reversed());

        for (var p : points) {
            var point = new Point(p[0], p[1]);
            if (heap.size() <= k) {
                heap.add(point);
                if (heap.size() > k) heap.remove();
            } else if (point.sqrD() < heap.peek().sqrD()) {
                heap.add(point);
                heap.remove();
            }
        }
        var res = new int[heap.size()][2];
        for (var i = 0; i < res.length; i++) {
            var point = heap.remove();
            res[i] = new int[]{point.x, point.y};
        }
        return res;
    }

    private static int distance(int x, int y) {
        return (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }

    //quickSelect
    public static int[][] kClosest2(int[][] points, int k) {
        var left = 0;
        var right = points.length - 1;

        while (left <= right) {
            var j = left;
            var point = points[right];
            for (var i = left; i <= right; i ++) {
                if (distance(points[i][0], points[i][1]) < distance(point[0], point[1])) {
                    swap(points, i, j);
                    j++;
                }
            }
            swap(points, j, right);
            if (j == k - 1) {
                break;
            } else if (j < k - 1) {
                left = j + 1;
            } else right = j - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private static void swap(int[][] points, int i, int j) {
        var temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
