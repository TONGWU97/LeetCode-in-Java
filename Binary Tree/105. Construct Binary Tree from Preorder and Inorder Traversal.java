/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) {
            return null;
        }
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(inorder[i] == value) {
                index = i;
                break;
            }
        }
        
        int[] left_preorder = new int[index];
        int[] left_inorder = new int[index];
        for(int i = 0; i < index; i++) {
            left_preorder[i] = preorder[i + 1];
            left_inorder[i] = inorder[i];
        }
        
        int[] right_preorder = new int[n - index - 1];
        int[] right_inorder = new int[n - index - 1];
        for(int i = index + 1; i < n; i++) {
            right_preorder[i - index - 1] = preorder[i];
            right_inorder[i - index - 1] = inorder[i];
        }
        
        root.right = buildTree(right_preorder, right_inorder);
        root.left = buildTree(left_preorder, left_inorder);
        return root;
    }
}