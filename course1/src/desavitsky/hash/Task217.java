package desavitsky.hash;

import java.util.HashSet;

// Contains Duplicate
public class Task217 {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (var i: nums) {
            if (!set.add(i)) return true;
        }
        return false;
    }
}
