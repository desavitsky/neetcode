package desavitsky.arrays;

import java.util.Arrays;

// Remove Element
public class Task27 {
    public static void main(String[] args) {
        final var nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
        final var nums1 = new int[]{1};
        System.out.println(removeElement(nums1, 1));
        System.out.println(Arrays.toString(nums1));
    }

    public static int removeElement(int[] nums, int val) {
        var k = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
