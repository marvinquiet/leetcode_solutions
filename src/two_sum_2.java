/**
 * Created by wjma on 7/19/16.
 *
 Similar to two_sum, but sorted array

 Sorted Array --> Hint:
 1. Binary search
 2. Two Pointers

 */
public class two_sum_2 {
    public int[] twoSum(int[] nums, int target){
        if (nums == null || nums.length < 2) return null;
        int i = 0, j = nums.length-1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else return new int[]{i, j};
        }

        return null;
    }
}
