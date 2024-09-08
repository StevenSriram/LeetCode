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
    public ListNode reverseList(ListNode head) {
        // Previous -> Current -> Next
        ListNode prev = null;
        ListNode cur = head;
        ListNode nxt = null;

        // cur not NULL
        while(cur != null)
        {
            // move Next
            nxt = cur.next;

            // Current points to Previous
            cur.next = prev;
            // move Previous
            prev = cur;
            
            // move Current
            cur = nxt;
        }
        // Next = Current = NULL then Previous = head
        return prev;
    }
}