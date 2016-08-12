import java.util.List;

/**
 * Created by marvin on 16/8/12.
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode dummyHead = dummy;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                dummy.next = head1;
                head1 = head1.next;
            }
            else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }

        if (head1 != null) {
            dummy.next = head1;
        }

        if (head2 != null) {
            dummy.next = head2;
        }

        return dummyHead.next;
    }
}
