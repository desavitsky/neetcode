package desavitsky.kadane;

import java.util.Arrays;

public class Task53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(Arrays.toString(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(Arrays.toString(maxSubArray2(new int[]{1})));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(Arrays.toString(maxSubArray2(new int[]{5, 4, -1, 7, 8})));
    }

    public static int maxSubArray(int[] nums) {
        var maxSum = nums[0];
        var curSum = 0;

        for (var el : nums) {
            curSum = Math.max(curSum + el, el);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public static int[] maxSubArray2(int[] nums) {
        var maxSum = nums[0];
        var curSum = 0;
        var maxLeft = 0;
        var maxRight = 0;
        var left = 0;


        for (var right = 0; right < nums.length; right++) {
            if (curSum < 0) {
                left = right + 1;
                curSum = 0;
            }
            curSum = curSum + nums[right];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxLeft = left;
                maxRight = right;
            }

        }

        return Arrays.copyOfRange(nums, maxLeft, maxRight + 1);
    }
}
