/**
 * Created by wjma on 7/29/16.
 *
 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.


 HINT: Sliding window
 */
public class longest_substring_at_most_two_distinct_char {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // i indicates character change point
        // j indicates sliding window left
        // k indicates sliding window right
        // when not in the two chars, then left points to the next change point --> i+1
        // when going to an end, the right max is s.length(), left is j
//        int maxLen = 0, i = -1, j = 0, k = 0;
//        int len = s.length();
//        for (k = 1; k < len; k++) {
//            if (s.charAt(k) == s.charAt(k-1)) continue;
//            if (i >= 0 && s.charAt(i) != s.charAt(k)) {
//                maxLen = Math.max(maxLen, k-j);
//                j = i+1;
//            }
//            i = k-1;
//        }
//        maxLen = Math.max(s.length()-j, maxLen);
//
//        return maxLen;

        //count char number
        int[] chars = new int[256];
        int numberDistinct = 0, maxLen = 0, i = 0, j = 0;
        for (j = 0; i < s.length(); j++) {
            if (chars[s.charAt(j)] == 0) numberDistinct++;
            chars[s.charAt(j)]++;
            while (numberDistinct > 2) {
                chars[s.charAt(i)]--;
                if (chars[s.charAt(i)] == 0) numberDistinct--;
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
