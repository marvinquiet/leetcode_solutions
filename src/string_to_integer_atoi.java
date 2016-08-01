/**
 * Created by wjma on 7/25/16.
 *
 * Implement atoi to convert a string to an integer.
 The atoi function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 and interprets them as a numerical value.
 The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.
 If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values, the maximum integer value (2147483647) or
 the minimum integer value (–2147483648) is returned.
 */
public class string_to_integer_atoi {
    private static int LIMIT = Integer.MAX_VALUE/10;
    public int myAtoi(String str) {
        int len = str.length();
        int i = 0;
        while (i < len && Character.isWhitespace(str.charAt(i))) i++;
        boolean plusFlag = true;
        if (i < len && str.charAt(i) == '+') i++;
        else if (i < len && str.charAt(i) == '-') {
            plusFlag = false;
            i++;
        }

        int num = 0;
        while(i < len && Character.isDigit(str.charAt(i))) {
            if (num > LIMIT || num == LIMIT && Character.getNumericValue(str.charAt(i)) >= 8) {
                if (plusFlag) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            num = num*10 + Character.getNumericValue(str.charAt(i));
            i++;
        }
        if (!plusFlag) return -num;
        return num;
    }
}
