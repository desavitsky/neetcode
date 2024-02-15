package desavitsky.kadane;

import static java.lang.StringTemplate.STR;

public class Task918 {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }


    public static int maxSubarraySumCircular(int[] nums) {
        var maxSum = nums[0];
        var minSum = nums[0];
        var totalSum = 0;
        var curMaxSum = 0;
        var curMinSum = 0;

        for (var el : nums) {
            totalSum += el;
            curMaxSum = Math.max(curMaxSum + el, el);
            curMinSum = Math.min(curMinSum + el, el);

            maxSum = Math.max(curMaxSum, maxSum);
            minSum = Math.min(curMinSum, minSum);
            System.out.println(STR."totalSum = \{totalSum} curMaxSum = \{curMaxSum} curMinSum = \\{curMinSum}");
            System.out.println(STR."maxSum = \{maxSum} ");
            System.out.println(STR."minSum = \{minSum} ");
        }

        return maxSum >= 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    }

}
