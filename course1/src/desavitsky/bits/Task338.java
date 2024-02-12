package desavitsky.bits;

import java.util.Arrays;

// Counting bits
public class Task338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(8)));
    }
    public static int[] countBits(int n) {
        var bits = new int[n + 1];
        var prev = 1;
        for (var i = 1; i <= n; i++) {
            if (i == prev * 2) {
                prev *= 2;
            }
            bits[i] = 1 + bits[i - prev];
        }
        return bits;

        // 0000 0 - 0
        // 0001 1 - 1
        // 0010 2 - 1
        // 0011 3 - 2
        // 0101 4 - 1
        // 0110 5 - 2
        // 0111 6 - 3
        // 1000 7 - 1
    }
}
