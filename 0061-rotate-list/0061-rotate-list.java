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
    
    public int countNodes(ListNode head){
        ListNode tail = head;
        if(head == null ) return 0;        
        int count = 1;
        while(tail.next!=null){
            count ++ ;
            tail = tail.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = countNodes(head);
        if(n == 0) return head;

         k = k%n;
        if(k == 0) return head;

        ListNode temp= head;
        for(int i=1; i<n-k ;i++){
            temp = temp.next;
        }

        ListNode newhead = temp.next;
        ListNode tail = newhead;
        while(tail.next!=null) tail = tail.next;
        tail.next = head;
        temp.next = null;

        return newhead;
    }
}