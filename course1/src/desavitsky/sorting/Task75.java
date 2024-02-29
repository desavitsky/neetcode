package desavitsky.sorting;

import java.util.Arrays;

//Sort Colors
public class Task75 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        var colors = new int[3];

        for (int i: nums) {
            colors[i]++;
        }
        var ind = 0;
        for (var i = 0; i < colors.length; i++) {
            var n = colors[i];
            while (n > 0) {
                nums[ind] = i;
                ind++;
                n--;
            }
        }
    }
}
