/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Two pointers
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;

    }
}
