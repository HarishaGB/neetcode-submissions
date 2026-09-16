/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return;
        }

        // Check if current node is good
        if (node.val >= maxSoFar) {
            count++;
        }

        // Update maximum for children
        maxSoFar = Math.max(maxSoFar, node.val);

        // Traverse left
        dfs(node.left, maxSoFar);

        // Traverse right
        dfs(node.right, maxSoFar);
    }
}
