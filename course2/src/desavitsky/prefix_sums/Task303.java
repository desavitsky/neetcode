package desavitsky.prefix_sums;

// 303. Range Sum Query - Immutable
public class Task303 {


}

class NumArray {

    private final int[] prefixes;

    public NumArray(int[] nums) {
        var prefixes = new int[nums.length];
        prefixes[0] = nums[0];
        for (var i = 1; i < nums.length; i++) {
            prefixes[i] = prefixes[i - 1] + nums[i];
        }
        this.prefixes = prefixes;
    }

    public int sumRange(int left, int right) {
        var prefixRight = prefixes[right];
        var prefixLeft = left > 0 ? prefixes[left - 1] : 0;
        return prefixRight - prefixLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
