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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        // Empty tree is valid
        if (node == null) {
            return true;
        }

        // Current value must be inside the allowed range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree:
        // values must be smaller than current node
        boolean left = dfs(node.left, min, node.val);

        // Right subtree:
        // values must be greater than current node
        boolean right = dfs(node.right, node.val, max);

        return left && right;
    }
}
