package desavitsky.arrays;

//Concatenation of Array
public class Task1929 {

    public int[] getConcatenation(int[] nums) {
        var newArr = new int[nums.length * 2];
        var length = nums.length;
        for (var i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
            newArr[i + length] = nums[i];
        }
        return newArr;
    }

}
