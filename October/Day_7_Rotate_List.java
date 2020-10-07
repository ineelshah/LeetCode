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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || k == 0)
            return head;
        
        ListNode temp = head;
        int count = 1;
        
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }
        
        if(count == 1)
            return head;
                
        k = k % (count);
        
        if(k == 0) {
            return head;
        }
        
        temp.next = head;
        
        while(count > k) {
            temp = temp.next;
            count--;
        }
        head = temp.next;
        temp.next = null;
        
        return head;
        
        
        
    }
}