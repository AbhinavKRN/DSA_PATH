class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class findLength {
    public int getCount(Node head) {
        int count = 0;
        Node current = head; // Start from the head node

        // Traverse the list until we reach the end
        while (current != null) {
            count++;
            current = current.next; // Move to the next node
        }

        return count; // Return the count of nodes
    }
}
