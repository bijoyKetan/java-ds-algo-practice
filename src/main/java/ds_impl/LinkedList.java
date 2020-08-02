package ds_impl;

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

    public LinkedList addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return this;
    }

    public int getNodeVal(int index) {
        if (index < 0) throw new IllegalArgumentException("Index cannot be negative");
        int count = 0;
        Node current = head;
        while (count != index) {
            if (current == null) {
                throw new IllegalArgumentException("Invalid Input");
            }
            current = current.next;
            count++;
        }
        return current.data;
    }

    //TODO - Delete a node at a given index
    public LinkedList deleteNode(int index) {
        return null;
    }

    //Printing the items of linked list
    public void printList(LinkedList ls) {
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

    //Reversing linked list iteratively/ in constant space
    public LinkedList reverseListIteratively(LinkedList ls) {
        //1. Store next node
        //2. Reverse the pointer of current node
        //3. Move prev node to current node
        //4. Move current node to next node
        Node current = ls.head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ls.head = prev; //since current is null
        return ls;
    }

    @Test
    public void testLinkedList() {
        LinkedList ls = new LinkedList();
        ls.addLast(1).addLast(2).addLast(3).addLast(4).addLast(5);
        System.out.println("Original Linked list is: ");
        printList(ls); // 1,2,3,4,5

        reverseListIteratively(ls);
        printList(ls); // 5,4,3,2,1
        reverseListIteratively(ls);

        ls.addFirst(0);
        printList(ls); //0,1,2,3,4,5

        System.out.println(ls.getNodeVal(4));//4


    }
}