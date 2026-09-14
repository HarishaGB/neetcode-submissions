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

class Codec {

    private int index = 0;

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.toString();
    }

    private void serializeHelper(TreeNode node,
                                 StringBuilder result) {

        if (node == null) {
            result.append("N,");
            return;
        }

        result.append(node.val).append(",");

        serializeHelper(node.left, result);
        serializeHelper(node.right, result);
    }

    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        index = 0;

        return deserializeHelper(values);
    }

    private TreeNode deserializeHelper(String[] values) {

        String value = values[index++];

        if (value.equals("N")) {
            return null;
        }

        TreeNode node =
            new TreeNode(Integer.parseInt(value));

        node.left = deserializeHelper(values);

        node.right = deserializeHelper(values);

        return node;
    }
}