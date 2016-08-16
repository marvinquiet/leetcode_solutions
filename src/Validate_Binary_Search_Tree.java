import java.util.Stack;

/**
 * Created by wjma on 8/16/16.
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 不能只判断子和父亲的关系,同时右边子节点不能小于上一个父结点的值
 */
public class Validate_Binary_Search_Tree {
//    public boolean isValidBST(TreeNode root) {
//        // 使用long是防止值刚好在Integer.MAX_VALUE或者Integer.MIN_VALUE的界限;
//        // 因为TreeNode的值为int类型,因此可以用Long
//        // 或者可以使用null的方式
//        return isValidBST(root, null, null);
//    }
//
//    private boolean isValidBST(TreeNode root, Integer low, Integer high) {
//        if (root == null) return true;
//        return (low == null || root.val > low)
//                && (high == null || root.val < high)
//                && isValidBST(root.left, low, root.val)
//                && isValidBST(root.right, root.val, high);
//    }


    private boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        while (nodeStack != null) {
            TreeNode node = nodeStack.pop();
            if (node.left != null) {
                
            }

        }
    }
}
