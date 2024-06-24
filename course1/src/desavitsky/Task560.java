package desavitsky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 2}, 2));
        System.out.println(subarraySum(new int[]{1, 1, 2}, 0));
        System.out.println(subarraySum(new int[]{1, 2, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1}, 1));
        System.out.println(subarraySum(new int[]{1}, 0));
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }

    public static int subarraySum(int[] nums, int k) {
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
