/**
 * Created by wjma on 7/26/16.
 *
 Validate if a given string is numeric. Some examples:
 "0"  true
 "0.1"  true
 "abc"  false

 */
public class valid_number {
    public boolean isNumber(String s) {
        int len = s.length();
        int i = 0;
        // heading white spaces
        while (i < len && Character.isWhitespace(s.charAt(i))) i++;
        // sign
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumber = false;

        while (i < len && Character.isDigit(s.charAt(i))) {
            i++;
            isNumber = true;
        }
        // decimal
        if (i < len && s.charAt(i) == '.') {
            i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isNumber = true;
            }
        }

        // 1e10 make sure before e is number first | set false | judge after
        if (isNumber & i < len && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            isNumber = false;
            if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isNumber = true;
            }
        }

        while (i < len && Character.isWhitespace(s.charAt(i))) i++;
        return isNumber && i == len;
    }
}
