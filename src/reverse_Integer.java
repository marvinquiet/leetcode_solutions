/**
 * Created by wjma on 8/12/16.
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class reverse_Integer {
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            // overflow border
            if (Math.abs(num) > Integer.MAX_VALUE/10) {
                return 0;
            }
            num = num*10 + x % 10;
            x /= 10;
        }
        return num;
    }
}
