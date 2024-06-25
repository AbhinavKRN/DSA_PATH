class Solution {
    public ListNode reverseKGroup(ListNode A, int B) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 0;
        ListNode temp = A;
        int groupSize = 0;
        while (temp != null && groupSize < B) {
            temp = temp.next;
            groupSize++;
        }
        if (groupSize < B) {
            return A;
        }
        while (curr != null && count < B) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            A.next = reverseKGroup(next, B);
        }

        return prev;
    }
}
