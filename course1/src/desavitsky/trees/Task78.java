package desavitsky.trees;

import java.util.ArrayList;
import java.util.List;

// Subsets // TODO: check solutions in leetcode
public class Task78 {

    public static List<List<Integer>> subsets(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> acc) {
        if (i >= nums.length) {
            acc.add(List.copyOf(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, acc);
        subset.removeLast();
        dfs(nums, i + 1, subset, acc);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
