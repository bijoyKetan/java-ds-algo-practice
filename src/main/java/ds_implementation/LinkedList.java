package ds_implementation;

// Implement a linked List. The head should describe the entire list.
// Expected code that should work
// LinkedList linkedList = new LinkedList(); => Creation of new LinkedList
// linkedList.add(5).add(7).add(9);
// linkedList.print(); => 5,7,8
// linkedList.reverse();
// linkedList.print() => 8,7,5

import org.junit.jupiter.api.Test;

public class LinkedList {

    //Node class to contain a value and a pointer to the next node.
    static class Node {
        int data;
        Node next; //by default next is null

        public Node(int data) {
            this.data = data;
        }
    }

    //Head should describe the entire linked list
    private Node head;

    //Adding item to linkedList at the end.
    public LinkedList addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return this;
    }

    //Printing the items of linked list
    public static void printList(LinkedList ls) {
        Node temp = ls.head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + ",");
            } else {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public static LinkedList reverseList(LinkedList head) {
        return null;
    }

    @Test
    public void testLinkedList() {
        LinkedList ls = new LinkedList();
        ls.addLast(4).addLast(5).addLast(6);
        printList(ls);
    }
}