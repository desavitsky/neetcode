package desavitsky.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Climbing Stairs
public class Task70 {

    public static void main(String[] args) {
        var start = Instant.now();
        System.out.println(climbStairs(44));
        var end = Instant.now();
        System.out.println(Duration.between(start, end));
        //1134903170
        //PT0.000127S
    }

    public static int climbStairs(int n) {
        var memo2 = new int[n + 1];
        memo2[0] = 1;
        memo2[1] = 1;
        return rec(n, memo2);
    }

    private static int rec(int n, int[] memo) {
        var memoValue = memo[n];
        if (memoValue != 0) return memoValue;
        else {
            var leftCount = rec(n - 1, memo);
            var rightCount = rec(n - 2, memo);
            var total = leftCount + rightCount;
            memo[n] = total;
            return total;
        }
    }


}
