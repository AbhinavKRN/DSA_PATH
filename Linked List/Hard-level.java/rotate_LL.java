/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        int size = 1;
        // finding the size of list
        while (p.next != null) {
            p = p.next;
            size++;
        }
        // calculating the seperation point
        int t = k % size;
        // in case the same list will be returned after rotation
        if (t == 0) {
            return head;
        }
        // taking two pointers
        ListNode curr = head;
        int curr_ptr = 1;
        int prev_ptr = 0;
        ListNode prev = null;
        // finding the seperation point
        while (curr.next != null) {
            if (curr_ptr - prev_ptr >= t) {
                curr = curr.next;
                prev = (prev_ptr == 0) ? head : prev.next;
                curr_ptr++;
                prev_ptr++;
            } else {
                curr = curr.next;
                curr_ptr++;
            }
        }
        // making prev as the last node of list
        ListNode q = prev.next;
        prev.next = null;
        ListNode r = q;
        // traversing the left out list
        while (q.next != null) {
            q = q.next;
        }
        // adding it to head
        q.next = head;
        // setting the head
        head = r;
        return head;

    }
}