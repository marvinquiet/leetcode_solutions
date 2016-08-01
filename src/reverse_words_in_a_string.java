import java.util.Arrays;

/**
 * Created by wjma on 7/20/16.
 */
public class reverse_words_in_a_string {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int j = s.length();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') j = i;
            else if (i == 0 || s.charAt(i-1) == ' ') {
                if (stringBuilder.length() != 0)
                    stringBuilder.append(' ');
                stringBuilder.append(s.substring(i, j));
            }
        }
        return stringBuilder.toString();
    }

    private String reverseWord(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < len/2; i++) {
            char temp = str[len-i-1];
            str[len-i-1] = str[i];
            str[i] = temp;
        }
        return new String(str);
    }
}
