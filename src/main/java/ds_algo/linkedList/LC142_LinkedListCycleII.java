package ds_algo.linkedList;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
public class LC142_LinkedListCycleII {
    public ListNode detectCycleExtraSpace(ListNode head) {
        ListNode pointer = head;
        Set<ListNode> seen = new HashSet<>();
        while (pointer != null) {
            if (seen.contains(pointer)) {
                return pointer;
            } else {
                seen.add(pointer);
            }
            pointer = pointer.next;
        }
        return null;
    }


    //Implement without using extra space
    public ListNode detectCycle(ListNode head) {
        //find length of cycle
        //move fast pointer length steps ahead of slow pointer
        //where they meet is the start of the cycle


        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;

        //check if there is a cycle and find the len
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){ //cycleEncountered
                hasCycle = true;
                break;
            }
        }

        //no cycle
        if (!hasCycle)return null;

        //Otherwise measure length
        slow = slow.next;
        int len = 1;
        while (slow != fast){
            len++;
            slow = slow.next;
        }

        slow = head;
        for (int i=0; i< len; i++){
            fast = fast.next;
        }

        while (slow != fast){
            slow = slow.next;
            fast= fast.next;

        }

        return slow;

    }



    @Test
    public void testLLCycleLength() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + detectCycleExtraSpace(head).val);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + detectCycleExtraSpace(head).val);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + detectCycleExtraSpace(head).val);


        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + detectCycle(head).val);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + detectCycle(head).val);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + detectCycle(head).val);
    }
}
