package desavitsky.sliding;

public class Task1343 {

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        var result = 0;
        var sumInSubarray = 0;
        for (var i = 0; i < arr.length; i++) {
            sumInSubarray += arr[i];
            if (i >= k - 1) {
                if (sumInSubarray >= threshold * k) result++;
                sumInSubarray -= arr[i - k + 1];
            }
        }
        return result;
    }
}
