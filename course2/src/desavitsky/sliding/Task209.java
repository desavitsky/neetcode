package desavitsky.sliding;

// 209. Minimum Size Subarray Sum
public class Task209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1}));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        var len = nums.length + 1;

        var sum = 0;
        var left = 0;
        for (var right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(right - left + 1, len);
                if (len == 1) return 1;
                sum -= nums[left];
                left++;
            }
        }
        return len > nums.length ? 0 : len;
    }
}
