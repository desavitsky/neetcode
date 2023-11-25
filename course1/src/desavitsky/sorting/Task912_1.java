package desavitsky.sorting;

import java.util.Arrays;

// Sort an Array / Insertion sort
public class Task912_1 {

    public static void main(String[] args) {
        var arr = new int[]{1, 2, 4, 6, 2, 7, 3, 5};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] nums) {
        for (var i = 1; i < nums.length; i++) {
            var j = i - 1;
            while (j >= 0 && nums[j + 1] < nums[j]) {
                var temp = nums[j + 1];
                nums[j + 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }
}
