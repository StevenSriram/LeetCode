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
    public ListNode middleNode(ListNode head) {
        // Slow - Fast Pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // fast not NULL
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;

            // handle Odd Case and Even (second middle) Case
            if(fast != null)
                fast = fast.next;
        }
        // slow is Middle of Linked List
        return slow;
    }
}