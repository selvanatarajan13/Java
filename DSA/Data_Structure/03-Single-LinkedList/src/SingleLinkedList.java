public class SingleLinkedList {

    Node head;

    class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public SingleLinkedList() {
        this.head = null;
    }

    public void insert(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = node;

        }
    }

    public void insertAtBeg(int val) {
        Node node = new Node(val);

        node.next = head;

        head = node;
    }

    public void insertAtEnd(int val) {
        Node node = new Node(val);

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
    }

    public void insertAtPos(int pos, int val) {

        if (pos < 1) {
            insertAtBeg(val);
        }

        if (pos == 1) {
            Node temp;
            Node node = new Node(val);

            temp = head.next;
            head.next = node;
            node.next = temp;
        }

        if (pos > 1) {
            int count = 1;
            Node trav = head;
            Node temp;
            Node node = new Node(val);

            while (count < pos) {
                trav = trav.next;
                count++;
            }
            temp = trav.next;
            trav.next = node;
            node.next = temp;

        }
    }

    public void deleteAtBeg() {
        Node temp;

        temp = head.next;
        System.out.println("Successfully deleted the element : " + head.data);
        head = temp;

    }

    public void deleteAtEnd() {
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        System.out.println("Successfully deleted node : " + currentNode.next.data);
        currentNode.next = null;
    }

    public void display() {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
}
