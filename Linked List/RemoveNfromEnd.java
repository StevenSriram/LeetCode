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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        /* Dummy Node points to Head
         stay before the Node to Delete for Deletion(.next.next) */
        ListNode dummy = new ListNode(-1, head);

        // prev, nxt points to Dummy
        ListNode prev = dummy;
        ListNode nxt = dummy;

        // Move nxt Node n-times 
        for(int i=0; i<=n; i++)
        {
            nxt = nxt.next;
        }

        // move prev, nxt till end of Linked List
        while(nxt != null)
        {
            prev = prev.next;
            nxt = nxt.next;
        }

        // at before the Position to Delete
        prev.next = prev.next.next;

        // Head of Linked List
        return dummy.next;
    }
}