/**
 * Created by wjma on 7/25/16.
 *
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class rotate_array {
    public void rotate(int[] nums, int k) {
        if (k == 0 || k % nums.length == 0) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }

    private void reverse(int[] nums, int begin, int end) {
        for (int i = 0; i < (end-begin)/2; i++) {
            int temp = nums[i+begin];
            nums[i+begin] = nums[end-i-1];
            nums[end-i-1] = temp;
        }
    }
}
