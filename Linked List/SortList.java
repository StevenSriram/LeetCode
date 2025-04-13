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
    public ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;

        // Move slow one step and fast two steps
        // When fast reaches end, slow will be at middle
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        // Dummy node to start merged list
        ListNode dummy = new ListNode(-1); 

        // Temp node to traverse merged list
        ListNode temp = dummy;

        // Merge two lists by comparing their values
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                //add L1 to merged List
                temp.next = l1;
                temp = l1;

                // move to next node
                l1 = l1.next;
            }
            else
            {
                //add L2 to merged List
                temp.next = l2;
                temp = l2;

                // move to next node
                l2 = l2.next;
            }
        }

        // Attach remaining part
        if(l1 != null)
            temp.next = l1;

        if(l2 != null)
            temp.next = l2;

        return dummy.next; 
    }

    public ListNode sortList(ListNode head) 
    {
        // List is empty or has only one node
        if(head == null || head.next == null)
            return head;

        // Find middle of List
        ListNode mid = findMiddle(head);

        // Split List into two halves [head -> mid] [mid.next -> end]
        ListNode left = head, right = mid.next;
        mid.next = null; // Break link

        // Recursively sort each half
        left = sortList(left);
        right = sortList(right);

        // Merge sorted halves
        return mergeList(left, right);
    }
}
