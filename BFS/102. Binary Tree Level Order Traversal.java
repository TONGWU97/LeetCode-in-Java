/* 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List是定义的接口,而ArrayList、LinkedList是它的具体实现  用List而不用ArrayList是工程上兼容性的考虑
        // 比如Map<Integer, Integer> = new HashMap<>();  => 代码加分项
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
            // no deep copy, 因为每次都是新开辟的level空间
            results.add(level);
        }
        return results;
    }
}

/*
queue中的方法：
add         增加一个元素                   如果队列已满，则抛出一个IIIegaISlabEepeplian异常
remove      移除并返回队列头部的元素         如果队列为空，则抛出一个NoSuchElementException异常
element     返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
offer       添加一个元素并返回true          如果队列已满，则返回false
poll        移除并返问队列头部的元素         如果队列为空，则返回null
peek        返回队列头部的元素              如果队列为空，则返回null
put         添加一个元素                   如果队列满，则阻塞
take        移除并返回队列头部的元素    
*/