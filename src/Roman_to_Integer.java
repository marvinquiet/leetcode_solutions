import java.util.HashMap;

/**
 * Created by marvin on 16/8/24.
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman_to_Integer {
    private HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
    public int romanToInt(String s) {
        int num = 0;
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // 每次都加上，但是如果发现小于后一个，则减去两倍
        int last = Integer.MAX_VALUE;
        for (int i = 0 ; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));
            if (last < current)
                num += current - 2 * last;
            else
                num += current;
            last = current;
        }

//        for (int i = 0; i < s.length()-1; i++) {
//            if ((s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'))
//                    || (s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
//                    || (s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')))
//                num -= romanMap.get(s.charAt(i));
//            else
//                num += romanMap.get(s.charAt(i));
//        }
//        num += romanMap.get(s.charAt(s.length()-1));
        return num;
    }
}
