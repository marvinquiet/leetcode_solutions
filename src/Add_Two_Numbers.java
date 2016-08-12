/**
 * Created by marvin on 16/8/12.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyPtr = dummy;
        int carry = 0, sum = 0;

        // 可以合并
        while (l1 != null || l2 != null) {
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;
            sum = num1+num2+carry;
            carry = sum / 10;
            sum %= 10;
            dummyPtr.next = new ListNode(sum);
            dummyPtr = dummyPtr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) dummyPtr.next = new ListNode(carry);

        return dummy.next;

//        while (l1 != null && l2 != null) {
//            sum = l1.val+l2.val+carry;
//            carry = sum / 10;
//            sum %= 10;
//            dummyPtr.next = new ListNode(sum);
//            dummyPtr = dummyPtr.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null) {
//            if (carry == 0) {
//                dummyPtr.next = l1;
//                break;
//            }
//            sum = l1.val+carry;
//            carry = sum / 10;
//            sum %= 10;
//            dummyPtr.next = new ListNode(sum);
//            dummyPtr = dummyPtr.next;
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//            if (carry == 0) {
//                dummyPtr.next = l2;
//                break;
//            }
//            sum = l2.val+carry;
//            carry = sum / 10;
//            sum %= 10;
//            dummyPtr.next = new ListNode(sum);
//            dummyPtr = dummyPtr.next;
//            l2 = l2.next;
//        }
//
//        if (carry == 1) dummyPtr.next = new ListNode(1);
//
//        return dummy.next;
    }
}
