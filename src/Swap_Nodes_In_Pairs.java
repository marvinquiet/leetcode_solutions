/**
 * Created by marvin on 16/8/12.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastPtr = dummy;
        while (head != null && head.next != null) {
            ListNode tmp = head.next.next;
            lastPtr.next = head.next;
            lastPtr.next.next = head;
            head.next = tmp;
            lastPtr = head;
            head = tmp;
        }

        return dummy.next;
    }
}
