/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        
        // Interface
        // 1.创建一个队列，把起始节点都放到里面(第一层节点)
        Queue<TreeNode> queue= new LinkedList<>();
        // 也可以用ArrayList的方式 ArrayList<TreeNode> queue = ...
        queue.offer(root);
        
        // 2.while队列不空，处理队列中的节点并拓展出新的节点
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // for上一层的节点拓展出下一层的节点
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(level);
        }
        // 将results中偶数项倒序
        for(int j = 1; j < results.size(); j+=2) {
            Collections.reverse(results.get(j));
        }
        return results;
    }
}

