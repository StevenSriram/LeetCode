/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = /**
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
    public boolean hasCycle(ListNode head) {
        // head null and only one Node 
        if(head == null || head.next == null)
            return false;

        // slow - fast Pointer
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast)
        {
            // no Cycle if null
            if(fast == null || fast.next == null)
                return false;
            
            // slow 1 step @ fast 2 step
            slow = slow.next;
            fast = fast.next.next;
        }
        // Cycle exits
        return true;
    }
}x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // slow - fast Pointer
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast)
        {
            // no Cycle if null
            if(fast == null || fast.next == null)
                return false;
            
            // slow 1 step
            slow = slow.next;

            // fast 2 step
            fast = fast.next.next;
        }
        // Cycle exits
        return true;
    }
}