/*
 * Construct the linked list,
 * Insert nodes at the beginning
 * Display the nodes
 * Insert node at the position
 * Count the number of nodes at present

 */

public class LinkedList {

    // construct the node
    // Node has data and reference that refer the next node
    class Node{
        // set attributes to the node
        private int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    // initialize the head node
    Node head;
    Node tail;

    // when new node created, at the beginning of the node must be null
    public LinkedList() {
        head = null;
        tail = null;
    }

    // Add nodes at the beginning
    public void addNewNodeAtBeginning(int val) {
        // create new node instance and set the node value through constructor
        Node newNode = new Node(val);

        /*
            Here, Note this point: when we perform the insertAt beginning,
            we have must handle the two scenario,
             1. If the node is empty,
             2. if the node have already another nodes
        */

        // when the node have empty, then perform do it the below
        if (head == null) {
            head = newNode;
        } else { // if the list is already contain any node
            newNode.next = head;
            head = newNode;
        }
    }

    // add nodes at the end
    public void addNewNodeAtEnd(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addNewNodeAtPos(int pos, int val) {
        Node temp = head;
        Node newNode = new Node(val);

        if (pos == 0) {
            addNewNodeAtBeginning(val);
            return;
        }

        for (int i=1; i<pos-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // update node
    public void updateNode(int pos, int val) {
        Node temp = head;

        for (int i=0; i<pos-1; i++) {
            temp = temp.next;
        }

        temp.data = val;
    }

    // display the node
    public void displayNodes() {
        Node temp = head; // start from head and jump on next node
        System.out.print("Head->");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next; // jump to next node
        }
        System.out.print("Null");
    }

    // count nodes
    public int countNodes() {
        int count = 0;
        Node temp = head;
        if (temp == null) {
            System.out.println("\nList empty");
        } else {
            while (temp != null) {
                count += 1;
                temp = temp.next;
            }
            System.out.println("\nNo of nodes : " + count);
        }
        return count;
    }

    // delete the node
    public void deleteNode(int val) {
        Node temp = head;
        Node previous = null;
        int count = countNodes();
        for (int i=0; i<count; i++) {
            previous = temp;
            temp = temp.next;
            if (temp.data == val) {
                previous.next = temp.next;
                break;
            } else {
                
            }
        }
    }
}