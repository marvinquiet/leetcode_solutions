/**
 * Created by wjma on 7/19/16.
 *
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Two pointers: is letter or alphabet && lowercase
 */
public class valid_palindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            while (i < j && ! Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && ! Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i < j) {
                if (Character.toLowerCase(s.charAt(i))
                        != Character.toLowerCase(s.charAt(j))) return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
