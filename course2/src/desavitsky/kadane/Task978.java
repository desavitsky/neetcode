package desavitsky.kadane;

// 978. Longest Turbulent Subarray
public class Task978 {

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(maxTurbulenceSize(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0}));
//        System.out.println(maxTurbulenceSize(new int[]{}));
    }


    public static int maxTurbulenceSize(int[] arr) {

        if (arr.length == 1) return 1;

        var maxLength = 1;
        var curLength = 1;

        var diff = 0;
        for (var i = 1; i < arr.length; i++) {
            var curDiff = arr[i] - arr[i - 1];
            var signum = Math.signum(curDiff) * Math.signum(diff);
            if (signum < 0) {
                curLength++;
            } else if (curDiff == 0) {
                curLength = 1;
            } else {
                curLength = 2;
            }
            maxLength = Math.max(maxLength, curLength);
            diff = curDiff;

        }
        return maxLength;
    }
}
