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
    private int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Get the best contribution from left subtree
        int leftGain = Math.max(0, dfs(node.left));

        // Get the best contribution from right subtree
        int rightGain = Math.max(0, dfs(node.right));

        // Best path passing THROUGH current node
        int currentPath = leftGain + node.val + rightGain;

        // Update global answer
        maxPathSum = Math.max(maxPathSum, currentPath);

        // Return best ONE-SIDE path to parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
