/**
 * Created by marvin on 16/8/24.
 *
 * Given an integer, convert it to a roman numeral.
 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Integer_to_Roman {
    // 写出special case即可
    private static int[] digits = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int k = num / digits[index];
            for (int i = 0; i < k; i++) {
                roman.append(romans[index]);
                num -= digits[index];
            }
            index++;
        }
        return roman.toString();
    }
}
