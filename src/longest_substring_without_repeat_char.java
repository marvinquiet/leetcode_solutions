import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by wjma on 7/28/16.
 *
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.
 */
public class longest_substring_without_repeat_char {
    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        HashSet<Character> strSet = new HashSet<Character>(); //  Or use boolean[256] to store
//        int i = 0, j = i;
//        for (i = 0; i < s.length(); i++) {
//            // judge if i already exists, then remove j until not exists, start again.
//            while (strSet.contains(s.charAt(i))) {
//                strSet.remove(s.charAt(j));
//                j++;
//            }
//            strSet.add(s.charAt(i));
//            maxLen = Math.max(maxLen, i-j+1);
//        }
//        return maxLen;

        int i = 0, maxLen = 0, j = i;
        HashMap<Character, Integer> strMap = new HashMap<Character, Integer>();
        for (i = 0; i < s.length(); i++) {
            // && strMap.get(s.charAt(i)) >= j :
            // never go before j! j always move forward -------->  and update the location
            // thus we need the judgement
            if (strMap.containsKey(s.charAt(i)) && strMap.get(s.charAt(i)) >= j){
                j = strMap.get(s.charAt(i))+1;
            }

            strMap.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}
