package desavitsky.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Task215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }

    public static int findKthLargest(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>();
        for (var i: nums) {
            if (heap.isEmpty() || heap.size() < k) {
                heap.add(i);
            } else if (i > heap.peek()) {
                heap.add(i);
                heap.remove();
            }
        }
        var heapSize = heap.size();
        for (var i = 0; i < (heapSize - k); i++) {
            heap.remove();
        }
        return heap.peek();
    }
}
