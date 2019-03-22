/*
Given a binary tree, return the postorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        //divide
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        
        //conquer
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}