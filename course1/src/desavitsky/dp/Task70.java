package desavitsky.dp;

import java.util.HashMap;
import java.util.Map;

public class Task70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs(int n) {
        var cache = new HashMap<Integer, Integer>();
        cache.put(0, 1);
        return climbStairsDP(n, cache);
    }

    private static int climbStairsDP(int left, Map<Integer, Integer> cache) {
        if (cache.containsKey(left)) return cache.get(left);
        else if (left < 0) return 0;
        else {
            var ways = climbStairsDP(left - 1, cache) + climbStairs(left - 2);
            cache.put(left, ways);
            return ways;
        }
    }
}
