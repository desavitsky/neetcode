package desavitsky.two_pointers;


// 125.Valid palindrome
public class Task125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {

            var l = s.charAt(left);
            var r = s.charAt(right);
            if (Character.isLetterOrDigit(l) && Character.isLetterOrDigit(r)) {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
                left++;
                right--;
            } else if (!Character.isLetterOrDigit(l)) {
                left++;
            } else {
                right--;
            }
        }

        return true;
    }
}
