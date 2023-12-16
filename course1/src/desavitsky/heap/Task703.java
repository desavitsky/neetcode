package desavitsky.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Task703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println( kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}

class KthLargest {


    private final Queue<Integer> heap = new PriorityQueue<>();
    private final int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        for (var i: nums) {
            heap.add(i);
            if (heap.size() == size + 1) {
                heap.remove();
            }
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() == size + 1) {
            heap.remove();
        }
        return heap.peek();
    }
}