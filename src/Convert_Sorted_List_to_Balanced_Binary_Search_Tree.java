/**
 * Created by wjma on 8/19/16.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_List_to_Balanced_Binary_Search_Tree {
    ListNode ptr;
    public TreeNode sortedListToBST(ListNode head) {
        ptr = head;
        int length = 0;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        ptr = head;
        return generateTree(0, length-1);
    }

    // 按照顺序的话，先生成左子树，再加上中间的节点，最后再生成右子树
    private TreeNode generateTree(int low, int high) {
        if (low > high) return null;
        int mid = low+(high-low)/2;
        TreeNode leftNode = generateTree(low, mid-1);
        TreeNode parent = new TreeNode(ptr.val);
        parent.left = leftNode;
        ptr = ptr.next;
        parent.right = generateTree(mid+1, high);
        return parent;
    }
}
