class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class InsertingNode {
    static void PrintList(ListNode head) // Function to print the LinkedList
    {
        ListNode curr = head;
        for (; curr != null; curr = curr.next)
            System.out.print(curr.val + "-->");
        System.out.println("null");
    }

    static ListNode InsertatFirst(int value, ListNode head) {

        // Step1 : creating a new Node with the given val
        ListNode newnode = new ListNode(value);

        // Step2 : Making next of newly created Node to point the head of LinkedList
        newnode.next = head;

        // Making the newly created Node as head
        head = newnode;
        return head;
    }
}
