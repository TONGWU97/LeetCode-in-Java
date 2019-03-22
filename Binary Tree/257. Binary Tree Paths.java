/*
Given a binary tree, return all root-to-leaf paths.
Note: A leaf is a node with no children.
Example:
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
class Solution {
    // 1.递归的定义：求出root为根的所有right-to-left path
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        // 3.递归的出口
        if(root == null) {
            return paths;
        }
        if(root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }
        // 2.递归的拆解
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for(String path: leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for(String path: rightPaths) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}