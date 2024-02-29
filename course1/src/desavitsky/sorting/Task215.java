package desavitsky.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

// Kth Largest Element in an Array
public class Task215 {

    public static void main(String[] args) {
        var arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest1(arr, 4));
        System.out.println(Arrays.toString(arr));
    }

    // heap sort
    public static int findKthLargest1(int[] nums, int k) {
        //create a min heap
        PriorityQueue<Integer> heap = new PriorityQueue(k);

        //iterate over the array
        for (int n : nums) {
            //first add the integer to heap
            heap.add(n);
            //if size of the heap is greater than k
            if (heap.size() > k) {
                //remove the root element (lowest of all)
                heap.poll();
            }
        }
        //finally heap has k largest elements left with root as the kth largest element
        return heap.peek();
    }

    // Not full quick sort
    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        return findKLargestInner(nums, k, 0, nums.length);
    }

    private static int findKLargestInner(int[] nums, int k, int s, int e) {
        var pivot = nums[e - 1];
        var pointer= s; //to move
        for (var i = s; i < e - 1; i++) {
            if (nums[i] >= pivot) {
                var temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }
        nums[e - 1] = nums[pointer];
        nums[pointer] = pivot;
        if (pointer + 1 == k) return pivot;
        else if (pointer >= k) return findKLargestInner(nums, k, 0, pointer);
        else return findKLargestInner(nums, k, pointer + 1, e);
    }
}
