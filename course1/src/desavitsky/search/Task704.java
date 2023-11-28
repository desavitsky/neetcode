package desavitsky.search;

// Binary Search
public class Task704 {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr, 2));
    }
    public static int search(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;
        while (l <= r) {
            var mid = (l + r)/2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
