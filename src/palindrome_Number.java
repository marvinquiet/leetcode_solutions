/**
 * Created by wjma on 8/12/16.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * 1. reverse and compare ==> palindrome
 * 2. two pointers from start and end
 */
public class palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; // palindrome should be non-negative
//        int reverseX = 0;
//        int originX = x;
//        while (originX != 0) {
//            if (Math.abs(reverseX) > Integer.MAX_VALUE/10) {
//                return false;
//            }
//            reverseX = reverseX * 10 + originX % 10;
//            originX /= 10;
//        }
//        return x==reverseX;

        // 边界条件把握的还是不好,需要考虑
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }
}
