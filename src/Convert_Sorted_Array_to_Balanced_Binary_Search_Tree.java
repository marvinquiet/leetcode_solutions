/**
 * Created by wjma on 8/17/16.
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_Array_to_Balanced_Binary_Search_Tree {
    // 选中点作为根, 二分法
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return generateTree(nums, 0, nums.length-1);
    }

    private TreeNode generateTree(int[] nums, int low, int high) {
        if (low > high) return null;

        int rootIndex = low + (high-low)/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = generateTree(nums, low, rootIndex-1);
        root.right = generateTree(nums, rootIndex+1, high);

        return root;
    }
}
