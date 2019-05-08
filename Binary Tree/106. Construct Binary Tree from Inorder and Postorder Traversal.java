/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if(n == 0) {
            return null;
        }
        int value = postorder[n-1];
        TreeNode root = new TreeNode(value);
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(inorder[i] == value) {
                index = i;
                break;
            }
        }
        
        int[] left_inorder = new int[index];
        int[] left_postorder = new int[index];
        for(int i = 0; i < index; i++) {
            left_inorder[i] = inorder[i];
            left_postorder[i] = postorder[i];
        }
        
        int[] right_inorder = new int[n - index - 1];
        int[] right_postorder = new int[n - index - 1];
        for(int i = index + 1; i < n; i++) {
            right_inorder[i - index - 1] = inorder[i];
        }
        for(int i = index; i < n - 1; i++) {
            right_postorder[i - index] = postorder[i];
        }
        
        root.left = buildTree(left_inorder, left_postorder);
        root.right = buildTree(right_inorder, right_postorder);
        return root;
    }
}