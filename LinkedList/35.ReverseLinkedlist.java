/**
 * Reverse a linked list.
Example
Example1:
For linked list 1->2->3, the reversed linked list is 3->2->1
Example2:
For linked list 1->2->3->4, the reversed linked list is 4->3->2->1
Challenge
Reverse it in-place and in one-pass
 */

 /**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}