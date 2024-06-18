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

    // Function to delete a node at position x
    public Node deleteNode(Node head, int x) {
        // If the linked list is empty
        if (head == null) {
            return null;
        }

        Node current = head;

        // If the head needs to be removed
        if (x == 1) {
            head = current.next; // Change head
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        // Traverse the list to find the node at position x
        for (int i = 1; current != null && i < x; i++) {
            current = current.next;
        }

        // If the position is greater than the number of nodes
        if (current == null) {
            return head;
        }

        // Change the next of the previous node
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        // Change the prev of the next node
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head;
    }

    // Function to print the doubly linked list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
