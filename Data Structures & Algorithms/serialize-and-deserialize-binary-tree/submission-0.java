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

public class Codec {

    // Encodes a tree to a single string.
     // Serialize
    public String serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();

        serializeHelper(root, result);

        return result.toString();
    }

    private void serializeHelper(TreeNode node,
                                 StringBuilder result) {

        // If node is null, store N
        if (node == null) {
            result.append("N,");
            return;
        }

        // Store current node
        result.append(node.val).append(",");

        // Serialize left subtree
        serializeHelper(node.left, result);

        // Serialize right subtree
        serializeHelper(node.right, result);
    }


    // Deserialize
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        int[] index = new int[1];

        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(String[] values,
                                        int[] index) {

        // Get current value
        String value = values[index[0]++];

        // N means null
        if (value.equals("N")) {
            return null;
        }

        // Create node
        TreeNode node = new TreeNode(Integer.parseInt(value));

        // Build left subtree
        node.left = deserializeHelper(values, index);

        // Build right subtree
        node.right = deserializeHelper(values, index);

        return node;
    }
    }

