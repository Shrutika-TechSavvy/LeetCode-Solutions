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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        StringBuilder sb =  new StringBuilder();
        
        while(temp!=null){
            int data = temp.val;
            String s = String.valueOf(data);
            sb.append(s);
            temp = temp.next;
        }
        String binaryString = sb.toString();
        return Integer.parseInt(binaryString, 2);
    }
}