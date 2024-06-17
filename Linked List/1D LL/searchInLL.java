class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class searchInLL {
    public boolean searchKey(Node head, int key) {
        Node current = head; // Start from the head node

        // Traverse the list until we reach the end
        while (current != null) {
            if (current.data == key) {
                return true; // Key is found
            }
            current = current.next; // Move to the next node
        }

        return false; // Key is not found in the list
    }

}
