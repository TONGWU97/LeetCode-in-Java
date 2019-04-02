/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加一个元素并返回true，如果队列已满则返回false
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                // 移除并返回队列头部的元素，如果队列为空则返回null
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
        Collections.reverse(results);
        return results;
    }
}

/* 
Collections类常用方法：
  1.sort：对集合排序
  2.shuffle：对集合随机排序(顺序可能不变)
  3.binarySearch：查找指定集合中的元素，返回所查找元素的索引
  4.max min
  5.indexOfSubList：查找subList在list中首次出现位置的索引
  6.lastIndexOfSubList：查找subList在list中最后出现位置的索引
  7.replaceAll：替换指定元素为某元素，若要替换的值（旧元素）存在刚返回true，反之返回false
  8.reverse：反转集合中元素的顺序
  9.rotate：集合中的元素向后移m个位置，在后面被遮盖的元素循环到前面来
  10.copy：将集合n中的元素全部复制到m中,并且覆盖相应索引的元素（从0开始覆盖，后面的元素向后移）
  11.swap：交换集合中指定元素索引的位置
  12.fill：用对象o替换集合list中的所有元素
  13.nCopies：返回大小为n的List，List不可改变,其中的所有引用都指向o
*/
