/* 
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Example: 
You may serialize the following tree:
    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append("[");
        while(!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if(head == null) {
                sb.append("null");
            } else {
                sb.append(head.val);
                queue.offer(head.left);
                queue.offer(head.right);
            }
            if(!queue.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("[]")) {
            return null;
        }
        String[] val = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftChild = true;
        for(int i = 1; i < val.length; i++) {
            if(!val[i].equals("null")) {
                TreeNode child = new TreeNode(Integer.parseInt(val[i]));
                if(isLeftChild) {
                    queue.peek().left = child;
                } else {
                    queue.peek().right = child;
                }
                queue.offer(child);
            }
            if(!isLeftChild) {
                queue.poll();
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));