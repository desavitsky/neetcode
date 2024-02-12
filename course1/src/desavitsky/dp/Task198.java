package desavitsky.dp;

// House Robber
public class Task198 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));

    }


    public static int rob(int[] nums) {
        var fst = 0;
        var snd = 0;

        for (var i = 0; i < nums.length; i++) {
            var curr = Math.max(fst + nums[i], snd);
            fst = snd;
            snd = curr;
        }
        return Math.max(fst, snd);
    }
}
