package desavitsky.two_pointers;

import java.util.Arrays;

// 80. Remove Duplicates from Sorted Array II
public class Task80 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr2));
        System.out.println(Arrays.toString(arr2));
    }

    public static int removeDuplicates(int[] nums) {
        var j = 0; // to insert
        var current = 0; // count of current number
        var count = 0;

        for (var i = 0; i < nums.length; i++) {
            var numI = nums[i];
            System.out.println(STR."i = \{i} j = \{j} cur = \{current} count = \{count} next = \{numI}");
            if (numI == current && count == 2) {
            } else if (numI == current) {
                count++;
                nums[j] = current;
                j++;
            } else {
                current = numI;
                nums[j] = numI;
                j++;
                count = 1;
            }
        }
        return j;
    }
}
