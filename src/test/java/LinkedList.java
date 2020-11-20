public class LinkedList {

    Node head;

    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    LinkedList(Node head) {
        this.head = head;
    }

    public static void printLinkedList(LinkedList linkedList) {
        Node current = linkedList.head;
        while (current != null) {
            System.out.println("Current node val i: " + current.val);
            current = current.next;
        }
    }


    public static void reverseLinkedList(LinkedList linkedList) {
        Node prev = null;
        Node current = linkedList.head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        linkedList.head = prev;
    }

    public static void main(String[] args) {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        LinkedList linkedList = new LinkedList(node1);
        //printLinkedList(linkedList);

        reverseLinkedList(linkedList);
        printLinkedList(linkedList);
    }

}
