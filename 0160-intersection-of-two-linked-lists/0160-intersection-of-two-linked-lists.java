/**
 * Definition for singly-linked list.
 * public class ListNode { 
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        while(headB!=null){
            ListNode temp = headA;
            while(temp!=null){
                if(temp == headB) return  headB;
                temp = temp.next;
            }
            headB = headB.next;

        }
        return null;
    }
}
*/

class Solution{
    int getDifference(ListNode head1, ListNode head2){
        int len1 = 0, len2 = 0;

        while(head1!=null){
            len1++;
            head1 = head1.next;
        }
        while(head2!=null){
            len2++;
            head2 = head2.next;
        }
        return len1 - len2;
    }
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int diff= getDifference(head1, head2);

        if(diff < 0 ){
            //Means the list2 > length of list1
            while(diff++ != 0) head2 = head2.next;

        }
        else{
            while(diff-- != 0) head1 = head1.next;
        }

        while(head1!=null){
            if(head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

}