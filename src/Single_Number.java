/**
 * Created by wjma on 8/22/16.
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Single_Number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
