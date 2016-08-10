/**
 * Created by wjma on 8/10/16.
 *
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * Caution: mind the border
 *
 * A Classical solution:
 * http://articles.leetcode.com/longest-palindromic-substring-part-ii
 */
public class Longest_Palindromic_Substring {
    // totally 2*n-1 center since some of the center is between two characters
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                end = i + len/2;
                start = i - (len-1)/2;
            }
        }
        return s.substring(start, end+1);
    }

    // Find a center and expand it
    private int expandFromCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R-L-1; // ! the first improper one and need to minus.
    }
}
