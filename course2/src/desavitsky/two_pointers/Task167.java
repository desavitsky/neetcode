package desavitsky.two_pointers;

// 167. Two Sum II - Input Array Is Sorted
public class Task167 {
    public int[] twoSum(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;

        while (left < right) {
            var sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            else if (sum < target) left++;
            else right--;
        }
        return numbers;
    }
}
