package desavitsky.fastslowpointers;

// 287. Find the Duplicate Number
public class Task287 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public static int findDuplicate(int[] nums) {

        var slow = 0;
        var fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        var slow2 = 0;
        do {
            slow = nums[slow];
            slow2 = nums[slow2];

        } while (slow != slow2);
        return slow;
    }
}
