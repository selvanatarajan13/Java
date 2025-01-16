/*
    * Construct the linked list,
    * Insert nodes at the beginning
    * Display the nodes

*/

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // add nodes at the beginning
        System.out.println("\nAdd nodes at the beginning");
        LinkedList node = new LinkedList();
        node.addNewNodeAtBeginning(5);
        node.addNewNodeAtBeginning(10);
        node.addNewNodeAtBeginning(15);
        node.addNewNodeAtBeginning(20);

        node.displayNodes();
        node.countNodes();

        node.addNewNodeAtBeginning(25);
        node.addNewNodeAtBeginning(30);
        node.addNewNodeAtBeginning(35);
        node.addNewNodeAtBeginning(40);
        node.displayNodes();
        node.countNodes();

        // add nodes at the end
        System.out.println("\nAdd nodes at the end");
        LinkedList myNode = new LinkedList();
        myNode.addNewNodeAtEnd(5);
        myNode.addNewNodeAtEnd(10);
        myNode.addNewNodeAtEnd(15);
        myNode.addNewNodeAtEnd(20);
        myNode.addNewNodeAtEnd(25);
        myNode.addNewNodeAtEnd(30);
        myNode.addNewNodeAtEnd(35);
        myNode.addNewNodeAtEnd(40);
        myNode.displayNodes();
        myNode.countNodes();

        myNode.addNewNodeAtPos(5,23);
        myNode.displayNodes();
        myNode.countNodes();

        myNode.addNewNodeAtPos(0,3);
        myNode.displayNodes();
        myNode.countNodes();

        myNode.addNewNodeAtPos(10,37);
        myNode.displayNodes();
        myNode.countNodes();

        myNode.updateNode(2,7);
        myNode.displayNodes();
        myNode.countNodes();

        myNode.deleteNode(10);
        myNode.deleteNode(20);
        myNode.displayNodes();
        myNode.countNodes();

    }
}
