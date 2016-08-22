/**
 * Created by wjma on 8/22/16.
 *
 * Given an array of integers, every element appears three times except for one. Find that single one.
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_two {
    public int singleNumber(int[] nums) {
        // 可以优化成按位循环，取每一位&1的结果
//        int[] bitNum = new int[32];
//        for (int num : nums) {
//            for (int i = 0; i < 32; i++) {
//                bitNum[i] += num & 1;
//                num >>= 1;
//            }
//        }
//        int result = 0;
//        for (int i = 31; i >= 0; i--) {
//            result <<= 1;
//            result |= (bitNum[i] % 3);
//        }
//        return result;

        // 统计第i位出现了几次，用ones表示出现一次，twos表示两次，threes表示三次
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            twos |= nums[i] & ones; // 先计算上次出现过一次，这次又出现了的，即出现两次：nums[i] & ones (这个ones是上次的ones结果)
            ones ^= nums[i]; // 计算本次 只出现一次的
            threes = ones & twos; // 本次出现一次和本次出现两次，即本次出现三次
            ones &= ~threes; // 如果有出现三次的，把那几位的出现一次清空
            twos &= ~threes; // 如果有出现三次的，把那几位的出现两次清空
        }
        return ones; // 返回只出现一次的
    }
}
