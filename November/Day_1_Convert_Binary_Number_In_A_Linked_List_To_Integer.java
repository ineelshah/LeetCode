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
        
        
        int n = 0;
        ListNode temp = head; 
        while(temp.next != null) {
            temp = temp.next;
            n++;
        }
        temp = head;
        int i = 0;
        int sum = 0;
        while(temp != null) {
            if(temp.val == 1) {
                sum += Math.pow(2, n - i);
            }
            i++;
            temp = temp.next;
        }
        return sum;
    }
}