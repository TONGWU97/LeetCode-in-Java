/*
Given a binary tree, return the inorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 实现一个标准的先进后出的栈
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<Integer>();
        while(root != null) {
            // 将root压入堆栈顶部
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            // 查看堆栈顶部的对象，但不从堆栈中移除它
            TreeNode node = stack.peek();
            result.add(node.val);
            if(node.right == null) {
                // 移除堆栈顶部的对象，并作为此函数的值返回该对象
                node = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //divide and conquer
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        //divide
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        //conquer
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}