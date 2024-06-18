class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

class DoublyLinkedList {
    Node head; // head of list

    // Function to add a new node with value x after pth node
    public void addNode(Node head, int p, int x) {
        Node current = head;
        int count = 0;

        // Traverse to the pth node
        while (current != null && count < p) {
            current = current.next;
            count++;
        }

        // If the pth node is found
        if (current != null) {
            // Create a new node with the given value x
            Node newNode = new Node(x);

            // Set the next of newNode to the next of current
            newNode.next = current.next;

            // Set the next of current to newNode
            current.next = newNode;

            // Set the prev of newNode to current
            newNode.prev = current;

            // If newNode's next is not null, set its prev to newNode
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }
    }

    // Function to print the doubly linked list
    public void printList(Node node) {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }
}