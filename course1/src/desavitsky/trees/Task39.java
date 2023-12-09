package desavitsky.trees;

import java.util.ArrayList;
import java.util.List;

// Combination Sum
public class Task39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        var acc = new ArrayList<List<Integer>>();
        backtrack(candidates, target, 0, new ArrayList<>(), 0, acc);
        return acc;

    }

    private static void backtrack(int[] candidates, int target, int current, List<Integer> subset, int sum, List<List<Integer>> acc) {
        if (current >= candidates.length || target < sum) return;
        else if (target == sum) {
            acc.add(List.copyOf(subset));
        }

        while (current < candidates.length) {
            subset.add(candidates[current]);
            sum += candidates[current];
            backtrack(candidates, target, current, subset, sum, acc);
            subset.removeLast();
            sum -= candidates[current];
            current++;
        }
    }

    // decision tree
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var acc = new ArrayList<List<Integer>>();
        backtrack2(candidates, target, 0, new ArrayList<>(), 0, acc);
        return acc;

    }

    private static void backtrack2(int[] candidates, int target, int current, List<Integer> subset, int sum, List<List<Integer>> acc) {
        if (current >= candidates.length || sum > target) {
        }
        else if (target == sum) {
            acc.add(List.copyOf(subset));
        } else {
            subset.add(candidates[current]);
            backtrack2(candidates, target, current, subset, sum + candidates[current], acc);
            subset.removeLast();
            backtrack2(candidates, target, current + 1, subset, sum, acc);
        }
    }


    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }
}
