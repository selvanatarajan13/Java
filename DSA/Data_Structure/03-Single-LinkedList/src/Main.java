import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /*
        * The linked list structure allows for efficient insertion and deletion of elements
        * from any position in the sequence.
         */

        System.out.println("Single linked list");

        int[] array = new int[5];

        array[1] = 12;

        for (int i : array) {
            System.out.println(i);
        }

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(1, 15);

        System.out.println(numbers);

        SingleLinkedList list = new SingleLinkedList();
        list.insert(10);
        list.insert(15);
        list.insert(20);
        list.insertAtBeg(5);
        list.insertAtBeg(1);
        list.insertAtEnd(25);
        list.insert(30);
        list.insertAtPos(1, 3);
        list.insertAtPos(1, 2);
        list.insertAtPos(3, 4);
        list.deleteAtBeg();
        list.deleteAtBeg();
        list.deleteAtBeg();
        list.deleteAtEnd();
        list.deleteAtEnd();
        list.deleteAtBeg();
        list.deleteAtBeg();
        list.deleteAtEnd();
        list.insertAtBeg(5);
        list.insertAtEnd(20);
        list.insertAtEnd(25);

        list.display();


//
//        Node head;
//
//        head = null;
//
//        System.out.println(head);
//
//        Node node1 = new Node(15);
//        Node node2 = new Node(20);
//        Node node3 = new Node(25);
//        Node node4 = new Node(30);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        head = node1;
//
//
//        System.out.println(node1);
//        System.out.print(node1.data + " " + node1.next);
//
//        System.out.println();
//        System.out.println(node2);
//        System.out.print(node2.data + " " + node2.next);
//
//        System.out.println();
//        System.out.println(node3);
//        System.out.print(node3.data + " " + node3.next);
//
//        System.out.println();
//        System.out.println("-".repeat(60));
//        System.out.println();
//
//        System.out.println("head node stores node1");
//        System.out.println("Address of node 1 : " + head);
//        System.out.println(head.data + " " + head.next);
//
//        System.out.println("-". repeat(60));
//        System.out.println();
//
//        while (head != null) {
//            System.out.print(head.data + "->");
//            head = head.next;
//        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}