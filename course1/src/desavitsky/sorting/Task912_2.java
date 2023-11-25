package desavitsky.sorting;

import java.util.Arrays;

import static java.lang.StringTemplate.STR;

// Sort an Array / Merge sort
public class Task912_2 {

    public static void main(String[] args) {
        var arr = new int[]{1, 2, 4, 6, 2, 7, 3, 5};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    private static int[] sortArray(int[] nums, int s, int e) {
        if (e - s + 1 <= 1) return nums;
        var m = (s + e) / 2;
        sortArray(nums, s, m);
        sortArray(nums, m + 1, e);
        merge(nums, s, m, e);
        return nums;
    }

    private static void merge(int[] nums, int s, int m, int e) {
        var left = Arrays.copyOfRange(nums, s, m + 1);
        var right = Arrays.copyOfRange(nums, m + 1, e + 1);
        var leftIndex = 0;
        var rightIndex = 0;
        var index = s;
        while (index != (e + 1)) {
            if (leftIndex != left.length && (rightIndex == right.length || left[leftIndex] <= right[rightIndex])) {
                nums[index] = left[leftIndex];
                leftIndex++;
            } else {
                nums[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }
    }


}
