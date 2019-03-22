/*
Given a binary tree, return the preorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,2,3]
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
// recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    // 把root为根的preorder加到result里, 在整个递归的过程中共享的同一个result
    private void traverse(TreeNode root, List<Integer> result) {
        // 递归的出口
        if(root == null) {
            return;
        }
        // 递归拆解
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

// non-recursive(iteratively) => divide and conquer
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        // divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        // conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
