/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        // set current pointer to the head node
        ListNode curr = head;
        // while the current pointer is not NULL
        while (curr != null) {
            // set the next pointer to the next node in the list
            next = curr.next;
            // reverse the current node's pointer to point to the previous node
            curr.next = prev;
            // set the previous pointer to the current node
            prev = curr;
            // move the current pointer to the next node
            curr = next;
        }
        // set the head pointer to the last node, which is the 
        // new first node after
        // reversal
        head = prev;
        return head;
    }
}