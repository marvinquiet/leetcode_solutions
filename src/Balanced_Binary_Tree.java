/**
 * Created by wjma on 8/17/16.
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in
 which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Balanced_Binary_Tree {
    // 计算了无用的高度, 会循环计算高度
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//
//        if (Math.abs(getHeight(root.left)-getHeight(root.right)) <= 1) {
//            return isBalanced(root.left) && isBalanced(root.right);
//        }
//        return false;
//    }
//
//    private int getHeight(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return getHeight(root) != -1;
    }

    // 剪枝,如果某一分支不符合直接退出
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int lHeight = getHeight(root.left);
        if (lHeight == -1) return -1;
        int rHeight = getHeight(root.right);
        if (rHeight == -1) return -1;

        return (Math.abs(lHeight-rHeight) <= 1)
                ? Math.max(lHeight, rHeight) + 1 : -1;
    }

}
