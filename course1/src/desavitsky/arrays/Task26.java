package desavitsky.arrays;

import java.util.Arrays;

//Remove Duplicates from Sorted Array
public class Task26 {

    public static void main(String[] args) {
        var nums = new int[]{0, 0, 4, 5, 5, 6, 9, 10, 10, 10, 11};
        var res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        var lag = 0;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                lag++;
            } else {
                nums[i - lag] = nums[i];
            }
        }
        return nums.length - lag;
    }
}
