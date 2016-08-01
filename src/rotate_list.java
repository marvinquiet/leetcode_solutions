/**
 * Created by wjma on 7/25/16.
 *
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curHead = head;
        int len = getLen(curHead);
        if (head == null || k == 0 || k % len == 0) return head;
        k = k % len;

        curHead = head;
        for (int i = 0; i < len-k-1; i++)
            curHead = curHead.next;
        ListNode tmpNode = curHead;
        curHead = curHead.next;
        tmpNode.next = null;

        tmpNode = curHead;
        while (tmpNode.next != null)
            tmpNode = tmpNode.next;
        tmpNode.next = head;

        return curHead;

//        if (head==null||head.next==null) return head;
//        ListNode dummy=new ListNode(0);
//        dummy.next=head;
//        ListNode fast=dummy,slow=dummy;
//
//        int i;
//        for (i=0;fast.next!=null;i++)//Get the total length
//            fast=fast.next;
//
//        for (int j=i-k%i;j>0;j--) //Get the i-k%i th node
//            slow=slow.next;
//
//        fast.next=dummy.next; //Do the rotation
//        dummy.next=slow.next;
//        slow.next=null;
//
//        return dummy.next;
    }

    private int getLen(ListNode head) {
        int count = 0;
        while (head != null){
            head = head.next;
            count++;
        }
        return count;
    }

}
