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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // Both nodes are smaller than current node
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both nodes are greater than current node
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Split occurs, or current node is p/q
            else {
                return root;
            }
        }

        return null;
    }
}
