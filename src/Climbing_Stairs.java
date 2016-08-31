/**
 * Created by wjma on 8/26/16.
 *
 * You are climbing a staircase. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to
 the top?

 =
 */
public class Climbing_Stairs {
    public int climbStairs(int n) {
        int a = 1, b = 2, f = 0;
        if (n <= 2) return n;
        while (n > 2) {
            f = a+b;
            a = b;
            b = f;
            n--;
        }
        return f;
    }
}
