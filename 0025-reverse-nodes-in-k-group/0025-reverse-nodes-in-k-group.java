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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode kthNode = null;
        ListNode prevNode = null;
        ListNode traverser = head;
        ListNode frontier = head;
        ListNode updatedHead = head;


        while(traverser != null) {
            kthNode = getKthNode(traverser, k);
            if(kthNode == null) {
                if(prevNode == null) return head;
                prevNode.next = traverser;
                return updatedHead;
            } 

            frontier = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(traverser);
            
            if(prevNode != null) {
                prevNode.next = kthNode;
            } else {
                updatedHead = kthNode;
            }
            prevNode = traverser;

            traverser = frontier;
        }
        return updatedHead;
    }

    public ListNode getKthNode(ListNode head, int k) {
        while(head != null) {
            if(k == 1) return head;
            head = head.next;
            k--;
        }
        return null;
    }


    public void reverseLinkedList(ListNode head) {
        ListNode traverser = head;
        ListNode tracker = null;
        ListNode frontier = head;

        while(traverser.next != null) {
            frontier = frontier.next;
            traverser.next = tracker;
            tracker = traverser;
            traverser = frontier;
        }
        traverser.next = tracker;
        return;
    }
}








