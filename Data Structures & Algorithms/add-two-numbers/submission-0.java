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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        int carry = 0;

        // Continue while either list has nodes or carry exists
        while (l1 != null || l2 != null || carry != 0) {

            // Get values, use 0 if the list is finished
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Add digits + carry
            int sum = digit1 + digit2 + carry;

            // Current digit
            int digit = sum % 10;

            // Carry for next position
            carry = sum / 10;

            // Add new node
            current.next = new ListNode(digit);
            current = current.next;

            // Move l1
            if (l1 != null) {
                l1 = l1.next;
            }

            // Move l2
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
        
    }
}
