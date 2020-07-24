package ds_implementation;

//Implement a linked List
//Expected code that should work
// LinkedList linkedList = new LinkedList();
// linkedList.add(5).add(7).add(9);
// linkedList.print(); => 5,7,8
// linkedList.reverse();
// linkedList.print() => 8,7,5

public class LinkedList {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList add(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return this;
    }

    public static void printList(LinkedList ls) {
        Node temp = ls.head;
        while (temp != null) {
            if (temp.next != null){
                System.out.print(temp.data + ",");
            } else {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList(); //Initialization
        ls.add(5).add(7).add(8);
        printList(ls); //Printing the values of the linked list ls
    }
}