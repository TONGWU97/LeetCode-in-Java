/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4 
*/

// recursively
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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];  // 用int count = 0会导致return的结果始终为0
        isValid(root, count);
        return count[0];
    }
    
    private boolean isValid(TreeNode node, int count[]) {
        if(node == null) {
            return true;
        }
        boolean left = isValid(node.left, count);
        boolean right = isValid(node.right, count);
        if(left && right) {
            if(node.left != null && node.val != node.left.val) {
                return false;
            }
            if(node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}