import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by marvin on 16/8/16.
 *
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 因为向下遍历，因此需要求depth+1
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.right == null && root.left != null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // 还可以用层序遍历，在遇到第一个叶子节点的时候停下，需要记录每一层是否遍历到尽头
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
//        treeNodes.add(root);
//        int depth = 1;
//        TreeNode right = root;
//        while (!treeNodes.isEmpty()) {
//            TreeNode node = treeNodes.poll();
//            if (node.left == null && node.right == null) break;
//            if (node.left != null) treeNodes.add(node.left);
//            if (node.right != null) treeNodes.add(node.right);
//            if (node == right) {
//                right = (node.right == null) ? node.left : node.right;
//                depth++;
//            }
//        }
//        return depth;
//    }
}
