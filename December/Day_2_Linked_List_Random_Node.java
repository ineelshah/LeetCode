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
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    ListNode headGlobal;
    private int n;
    
    public Solution(ListNode head) {
        headGlobal = head;
        n = 0;
        while(head != null) {
            head = head.next;
            n++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        
        Random rand = new Random();
        int val = rand.nextInt(n);
        
        ListNode temp = headGlobal;
        while(val > 0) {
            temp = temp.next;
            val--;
        }
        
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */