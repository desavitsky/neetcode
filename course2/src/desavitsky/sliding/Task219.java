package desavitsky.sliding;

import java.util.HashSet;

// 219. Contains Duplicate II
public class Task219 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        var window = new HashSet<Integer>();

        var left = 0;

        for (int right = 0; right < nums.length; right++) {

            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }

            if (window.contains(nums[right])) return true;

            window.add(nums[right]);
        }
        return false;
    }
}
