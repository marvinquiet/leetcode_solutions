/**
 * Created by wjma on 8/11/16.
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 Meaning:
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class one_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        // length > 1
        if (Math.abs(m-n) > 1) return false;
        // always m <= n
        if (m > n) return isOneEditDistance(t, s);
        int i = 0;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        // shift = 0 ==> editted | shift = 1 ==> added
        int shift = n-m;
        if (shift > 0) ++i;
        while (i < m && s.charAt(i) == t.charAt(i+shift)) i++;
        return i == m;
    }
}
