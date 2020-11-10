package ds_algo.linkedList;

import org.junit.jupiter.api.Test;

public class LC_876MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null)  return slow;
        return slow.next;
    }

    @Test
    public void testMiddle(){
        //[1,2,3,4,5]
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        assert(middleNode(n1).equals(n3));
    }
}
