import java.util.ArrayList;
import java.util.List;

/**
 * Created by marvin on 16/8/14.
 */
public class Copy_List_with_Random_Pointer {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
//            List<RandomListNode> randomLists = new ArrayList<RandomListNode>();
//            RandomListNode curHead = head, dummy = new RandomListNode(0), ptr = dummy;
//            while (curHead != null) {
//                ptr.next = new RandomListNode(curHead.label);
//                ptr.next.next = curHead.next;
//                curHead = curHead.next;
//                if (curHead.random == null) {
//                    randomLists.add(new RandomListNode(-1));
//                }
//            }
//            ptr = dummy.next;
//            for (int i = 0; i < randomLists.size(); i++) {
//                ptr.random = randomLists.get(i);
//                ptr = ptr.next;
//            }
//            return dummy.next;
            RandomListNode ptr = head;
            // insert into original two nodes;
            while (ptr != null) {
                RandomListNode node = new RandomListNode(ptr.label);
                node.next = ptr.next;
                ptr.next = node;
                ptr = node.next;
            }
            ptr = head;
            // use original two nodes relationship to get random;
            while (ptr != null) {
                ptr.next.random = (ptr.random == null) ? null : ptr.random.next;
                ptr = ptr.next.next;
            }
            ptr = head;
            // in case head is null;
            // break the connection and return to the original;
            RandomListNode newHead = (ptr == null) ? null : ptr.next;
            while (ptr != null) {
                RandomListNode copy = ptr.next;
                ptr.next = copy.next;
                ptr = ptr.next;
                copy.next = (ptr == null) ? null : ptr.next;
            }
            return newHead;
        }
    }


}
