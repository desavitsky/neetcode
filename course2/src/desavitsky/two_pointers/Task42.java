package desavitsky.two_pointers;


// 42. Trapping Rain Water
public class Task42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap2P(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(trap2P(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
        System.out.println(trap2P(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
    }

    public static int trap(int[] height) {
        var maxLeftSide = new int[height.length];
        var maxRightSide = new int[height.length];

        var maxLeft = 0;
        var maxRight = 0;

        for (var i = 1; i < height.length; i++) {

            maxLeft = Math.max(maxLeft, height[i - 1]);
            maxLeftSide[i] = maxLeft;

            var rightCoord = height.length - i;

            maxRight = Math.max(maxRight, height[rightCoord]);
            maxRightSide[rightCoord] = maxRight;
        }

        var volume = 0;
        for (var i = 1; i < height.length - 1; i++) {
            volume += Math.max(Math.min(maxLeftSide[i], maxRightSide[i]) - height[i], 0);
        }
        return volume;
    }

    public static int trap2P(int[] height) {
        var left = 0;
        var right = height.length - 1;

        var maxLeft = height[left];
        var maxRight = height[right];

        var volume = 0;

        while (left < right) {
            if (maxLeft > maxRight) {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                volume += maxRight - height[right];
            } else {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                volume += maxLeft - height[left];
            }

        }
        return volume;
    }
}