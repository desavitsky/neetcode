package desavitsky.hash;

import java.util.HashMap;

public class Task1 {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i <nums.length; i++) {
            var num = nums[i];
            var pairIndex = map.get(target - num);
            if (pairIndex != null) return new int[]{pairIndex, i};
            else map.put(num, i);
        }
        return nums;
    }
}
