class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Function to segregate the linked list
    void segregate() {
        // Count the number of 0s, 1s and 2s
        int count[] = { 0, 0, 0 };
        Node ptr = head;

        // Count the occurrences of 0, 1, and 2
        while (ptr != null) {
            count[ptr.data]++;
            ptr = ptr.next;
        }

        int i = 0;
        ptr = head;

        // Update the linked list with 0s, then 1s, then 2s
        while (ptr != null) {
            if (count[i] == 0) {
                i++;
            } else {
                ptr.data = i;
                count[i]--;
                ptr = ptr.next;
            }
        }
    }

    // Function to insert a new node at the end of the linked list
    void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

}
