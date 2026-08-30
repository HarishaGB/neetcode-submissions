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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min heap based on node value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Put first node of every non-empty list into heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Dummy node for result
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode node = pq.poll();

            // Add it to result
            current.next = node;
            current = current.next;

            // Add next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;

    }
}
