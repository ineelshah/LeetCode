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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode tempNext = head.next;
        ListNode prev = null;
        
        while(curr != null) {
            
            ListNode next = curr.next;
            if(next == null) 
                return tempNext;
            ListNode forward = next.next;
            
                
            curr.next = forward;
            next.next = curr;
            
            if(prev != null)
                prev.next = next;            
                        
            prev = curr;
            curr = curr.next;
            if(curr != null) 
                next = curr.next;
            
        }
        return tempNext;
    }
}