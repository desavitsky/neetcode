package desavitsky.search;

// Guess Number Higher or Lower
public class Task374 {

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }

    public static int guess(int n) {
        return Integer.compare(1702766719, n);
    }

    public static int guessNumber(int n) {
        var left = 1;
        var right = n;
        while (left <= right) {
            System.out.println(STR. "LEFT: \{ left } RIGHT: \{ right }" );
            var guess = left+(right-left)/2;
            if (guess(guess) == -1) right = guess - 1;
            else if (guess(guess) == 1) left = guess + 1;
            else return guess;
        }
        return -1;
    }
}
