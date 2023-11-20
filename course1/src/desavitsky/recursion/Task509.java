package desavitsky.recursion;

// Fibonacci Number
public class Task509 {
    public static void main(String[] args) {
        System.out.println(fib(40));
    }
    public static int fib(int n) {
        return revFib(0, 1, n);
    }

    public static int revFib(int prev0, int prev1, int n) {
        if (n == 0) return prev0;
        else return revFib(prev1, prev0 + prev1, n - 1);
    }
}
