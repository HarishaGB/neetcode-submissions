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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         // If root is null, no subtree can be found
        if (root == null) {
            return false;
        }

        // Check if the trees rooted at these nodes are identical
        if (sameTree(root, subRoot)) {
            return true;
        }

        // Search in the left and right subtrees
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode root1, TreeNode root2) {

        // Both are null → same
        if (root1 == null && root2 == null) {
            return true;
        }

        // One is null → different
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values are different → different
        if (root1.val != root2.val) {
            return false;
        }

        // Both left and right subtrees must be same
        return sameTree(root1.left, root2.left)
                && sameTree(root1.right, root2.right);

    }
}
