package desavitsky.search;

// Koko Eating Bananas
public class Task875 {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        var h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);
        while (left < right) {
            var count = 0;
            var mid = (left + right) / 2;
            for (var pile : piles) {
                count += (int) Math.ceil((double) pile / mid);
            }
            if (count <= h) {
                right = mid;
            } else left = mid + 1;

        }
        return right;
    }

    private static int findMax(int[] piles) {
        var max = 0;
        for (var pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }
}
