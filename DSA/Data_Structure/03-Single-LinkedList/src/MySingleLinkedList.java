public class MySingleLinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public MySingleLinkedList() {
        this.head = null;
    }

    public void insertAtBeg(int val) {
        Node node = new Node(val);

        node.next = head;

        head = node;

        System.out.println("Successfully added the element.." + val);
    }

    public void insertAtEnd(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;

        System.out.println("Successfully added the element.." + val);
    }

    public void display() {
        System.out.print("HEAD->");
        while (head != null) {
            System.out.print(head.data + "->");
            // System.out.println();
            // System.out.print(head.next + "->");
            head = head.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
