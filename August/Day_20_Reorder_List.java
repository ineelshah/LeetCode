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
    public void reorderList(ListNode head) {
        
        
        int length = 0;

        if (head == null || head.next == null) 
            return;
        
        Stack<ListNode> stack = new Stack<>();
        
        ListNode tempHead = head;
        int count = 0;
        
        while(tempHead != null)
        {
            stack.push(tempHead);
            tempHead = tempHead.next;
            count++;
        }
        
        count = count / 2;
        
        tempHead = head;
        
        while(count-- > 0)
        {
            ListNode temp1 = tempHead.next;
            ListNode temp2 = stack.pop();
            
            tempHead.next = temp2;
            temp2.next = temp1;
            
            tempHead = temp1;
        }
        
        if (tempHead != null) 
            tempHead.next = null;
                
    }
}


/*

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        // find the middle of the LinkedList
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow is now pointing to the middle node
        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode headFirstHalf = head;
        
        // rearrange to produce the LinkedList in the required order
        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;
            
            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }
        
        // set the next of the last node to 'null'
        if (headFirstHalf != null)
            headFirstHalf.next = null;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next  = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}

*/
