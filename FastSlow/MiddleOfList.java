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
    public ListNode middleNode(ListNode head) 
    {
        // Fast - Slow Pointer 
        ListNode slow = head;
        ListNode fast = head;

        // Fast - points to End , Slow - is at Middle
        while(fast != null && fast.next != null)
        {
            // Slow - one Step
            slow = slow.next;
            // Fast - two Step
            fast = fast.next.next;
        }

        // Middle of Linked List
        return slow;
    }
}
