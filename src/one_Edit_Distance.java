/**
 * Created by marvin on 16/8/11.
 *
 *Given two strings S and T, determine if they are both one edit distance apart.
 */
public class one_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m-n) > 1) return false;
        if (m > n) return isOneEditDistance(t, s);
        int i = 0;
        while (i < m && s.charAt(i) == t.charAt(i)) ++i;
        int shift = n-m;
        if (shift == 0) {
            if (i == m) return false;
            ++i;
        }
        while (i < m && s.charAt(i) == t.charAt(i+shift)) ++i;
        return i == m;
    }
}
