package desavitsky.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import static java.lang.StringTemplate.STR;

// Sort an Array - Quick sort
public class Task921_3 {

    public static void main(String[] args) {
        var arr = new int[50000];
        Arrays.fill(arr, 2);
        arr[0] = 3;
//        int[] arr = {1,1};
        var start = Instant.now();
        System.out.println();
        sortArray(arr);
        System.out.println(STR."DURATION: \{ Duration.between(Instant.now(), start).toMillis() }");
        System.out.println(Arrays.toString(arr));

    }

    public static int[] sortArray(int[] nums) {
        if (nums.length == 0) return nums;
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private static int[] sortArray(int[] nums, int s, int e) {
        if (s >= e) return nums;
        var pivot = selectPivot(nums, s, e);
        var temp = nums[pivot];
        nums[pivot] = nums[e];
        nums[e] = temp;
        var current = s;
        var toPut = s;
        while (current < e) {
            if (nums[current] <= nums[e]) {
                temp = nums[toPut];
                nums[toPut] = nums[current];
                nums[current] = temp;
                toPut++;
            }
            current++;
        }
        temp = nums[toPut];
        nums[toPut] = nums[e];
        nums[e] = temp;
        sortArray(nums, s, toPut - 1);
        sortArray(nums, toPut + 1, e);
        return nums;
    }

    private static int selectPivot(int[] nums, int s, int e) {
        var first = nums[s];
        var last = nums[e];
        var middle = nums[(e - s) / 2];
        var max = Math.max(first, Math.max(middle, last));
        int median;
        if (max == first) {
            median = Math.max(last, middle);
        } else if (max == last) {
            median = Math.max(first, middle);
        } else {
            median = Math.max(first, last);
        }
        if (median == first) return s;
        if (median == last) return e;
        return (e - s) / 2;
    }
}
