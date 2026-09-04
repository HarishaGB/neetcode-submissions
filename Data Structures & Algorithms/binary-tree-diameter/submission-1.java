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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return diameter;
    }

    private int height(TreeNode node) {
        // Empty tree has height 0
        if (node == null) {
            return 0;
        }

        // Get height of left subtree
        int leftHeight = height(node.left);

        // Get height of right subtree
        int rightHeight = height(node.right);

        // Diameter passing through current node
        int currentDiameter = leftHeight + rightHeight;

        // Update maximum diameter
        diameter = Math.max(diameter, currentDiameter);

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
