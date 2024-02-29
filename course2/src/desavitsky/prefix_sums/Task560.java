package desavitsky.prefix_sums;

import java.util.HashMap;

// 560. Subarray Sum Equals K
class Task560 {
    public int subarraySum(int[] nums, int k) {
        var count = 0;
        var prefixes = new HashMap<Integer, Integer>();
        prefixes.put(0,1);
        var sum = 0;
        for (var el: nums) {
            sum += el;
            var diff =  sum - k;
            if (prefixes.containsKey(diff)) {
                count += prefixes.get(diff);
            }
            prefixes.put(sum, prefixes.getOrDefault(sum, 0) + 1);
        }

        return count ;
    }
}