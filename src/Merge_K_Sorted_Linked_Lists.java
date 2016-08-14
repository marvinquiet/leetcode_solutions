import java.util.*;

/**
 * Created by marvin on 16/8/14.
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Merge_K_Sorted_Linked_Lists {
    private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode x, ListNode y) {
            return x.val - y.val;
        }
    };

    // 如果用merge 2 sorted lists 使用数组的思想 会超时
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode ptr = dummy;
        // 最小堆，最小堆插入为logk, 因此综合下来为 n*k*(logk)
        Queue<ListNode> curQueue = new PriorityQueue<ListNode>(lists.length, listComparator);
        for (ListNode node : lists) {
            if (node != null) {
                curQueue.add(node);
            }
        }

        while (!curQueue.isEmpty()) {
            ListNode node = curQueue.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next != null) {
                curQueue.add(node.next);
            }
        }

        return dummy.next;
    }

    // 长度会从 n -> 2*n -> 4*n -> .. -> (2 ** logk) * n
    // 数量会从 k -> k/2 -> k/4 -> .. -> 2 -> 1
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        int end = lists.length - 1;
//        while (end > 0) {
//            int begin = 0;
//            while (begin < end) {
//                lists[begin] = mergeTwoLists(lists[begin], lists[end]); // 调用merge two sorted lists.
//                begin++;
//                end--;
//            }
//        }
//        return lists[0];
//    }
}
