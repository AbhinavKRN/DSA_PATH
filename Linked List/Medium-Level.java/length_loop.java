class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head; // head of the list

    // Function to count the number of nodes in the loop
    static int countNodesinLoop(Node head) {
        Node slow = head, fast = head;

        // Detecting loop using Floyd’s Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a loop
            if (slow == fast) {
                // Loop detected, now count the number of nodes in the loop
                return countLoopLength(slow);
            }
        }

        // No loop detected
        return 0;
    }

    // Function to count the length of the loop
    private static int countLoopLength(Node loopNode) {
        Node temp = loopNode;
        int count = 1;

        while (temp.next != loopNode) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Helper function to add a node at the end of the list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Function to create a loop in the linked list
    public void createLoop(int k) {
        if (k == 0)
            return;

        Node temp = head;
        Node loopNode = null;
        int count = 1;

        // Traverse to the kth node
        while (temp.next != null) {
            if (count == k) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }

        // Create a loop by connecting the last node to the kth node
        if (loopNode != null) {
            temp.next = loopNode;
        }
    }
}