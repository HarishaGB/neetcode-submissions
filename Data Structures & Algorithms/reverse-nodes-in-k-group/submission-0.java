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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Node before the current group
        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node of the current group
            ListNode kth = getKthNode(groupPrev, k);

            // Fewer than k nodes remaining
            if (kth == null) {
                break;
            }

            // Save the head of the next group
            ListNode nextGroup = kth.next;

            // Reverse the current group
            ListNode prev = nextGroup;
            ListNode current = groupPrev.next;

            while (current != nextGroup) {

                ListNode next = current.next;

                current.next = prev;

                prev = current;
                current = next;
            }

            // New head of the reversed group
            ListNode groupHead = groupPrev.next;

            // Connect previous group to new head
            groupPrev.next = kth;

            // Move groupPrev to the end of reversed group
            groupPrev = groupHead;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode current, int k) {

        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
        
    }
}
