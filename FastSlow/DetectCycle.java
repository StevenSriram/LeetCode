/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        // Empty List | One Node - No Cycle
        if(head == null || head.next == null)    
            return false;

        // Fast - Slow Pointer ( Floyd's Cycle )
        ListNode slow = head;
        ListNode fast = head;

        // check for End of Linked List
        while(fast != null && fast.next != null)
        {
            // Slow - one Step
            slow = slow.next;
            // Fast - two Step
            fast = fast.next.next;

            // Cycle exits (slow equals fast)
            if(slow == fast)
                return true;
        }

        // No Cycle exists
        return false;
    }
}