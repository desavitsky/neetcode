package desavitsky.bits;

// Number of 1 bits
public class Task191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(10101));
    }

    public static int hammingWeight(int n) {
        var count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}
