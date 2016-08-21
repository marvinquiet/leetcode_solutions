/**
 * Created by marvin on 16/8/19.
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to
 any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.

 当你觉得up-bottom会重复计算的时候，试一下bottom up
 */
public class Binary_Tree_Maximum_Path_Sum {
    int curSum;
    public int maxPathSum(TreeNode root) {
        curSum = Integer.MIN_VALUE;
        getPathSum(root);
        return curSum;
    }

    // 分为几种情况，即选了根及其左右，或者左子树和右子树只能选择一个，或者都不选
    private int getPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = getPathSum(root.left);
        int right = getPathSum(root.right);
        curSum = Math.max(root.val+left+right, curSum);
        int temp = root.val + Math.max(left, right);
        return temp > 0 ? temp : 0;
    }
}
