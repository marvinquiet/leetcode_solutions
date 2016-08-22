/**
 * Created by marvin on 16/8/21.
 *
 * ￼Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left
 ￼node that shares the same parent node) or empty, flip it upside down and turn it into a tree
 ￼where the original right nodes turned into left leaf nodes. Return the new root.

 Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5   2
    / \
   3   1
 */
public class Binary_Tree_Upside_Down {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return generateNewRoot(root, null);
    }

    // 需要一个存parent的点!! 即每次需要存下来parent的位置,防止指针丢失即可。
    private TreeNode generateNewRoot(TreeNode root, TreeNode parent) {
        if (root == null) return parent;
        TreeNode newRoot = generateNewRoot(root.left, root);
        root.left = (parent == null) ? null : parent.right;
        root.right = parent;
        return newRoot;
    }
}
