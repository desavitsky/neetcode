package desavitsky.prefix_sums;

import java.util.Arrays;

public class Task238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    // 1    2   3   4
    // 1    2   6   24
    // 24   24  12  4
    // 24   12  8   6
    public static int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        result[0] = 1;
        for (var i = 0; i < nums.length - 1; i++) {
            result[i + 1] = result[i] * nums[i];
        }
        var postFix = 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] = postFix * result[i];
            postFix *= nums[i];
        }
        return result;
    }
}
