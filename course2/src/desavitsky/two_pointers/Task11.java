package desavitsky.two_pointers;

public class Task11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }
    public static int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;

        var maxVolume = 0;

        while (left < right) {

            var leftHeight = height[left];
            var rightHeight = height[right];

            maxVolume = Math.max(maxVolume, (right  - left) * Math.min(leftHeight, rightHeight));

            if (leftHeight < rightHeight) {
                left++;
            } else if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
                right--;
            }

        }
        return maxVolume;
    }
}
