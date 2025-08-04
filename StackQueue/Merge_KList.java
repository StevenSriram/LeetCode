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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists == null || lists.length == 0)
            return null;

        // Min-Heap to get Node with Smallest value
        Queue<ListNode> pq = new PriorityQueue<>((i, j) -> i.val - j.val);

        // Add head of each non-null list to PQ
        for (ListNode head : lists) 
        {
            if (head != null)
                pq.offer(head);
        }

        // Dummy node for Merged List
        ListNode dummy = new ListNode(-1);

        // temp to Traverse List
        ListNode temp = dummy;  

        /* Heap always maintains K sizes Node */
        while (! pq.isEmpty()) 
        {
            // Get smallest node
            ListNode min = pq.poll();

            // Add it to merged list
            temp.next = min;
            temp = temp.next;

            // If node has a next, add to PQ
            if (min.next != null)
                pq.offer(min.next);
        }

        return dummy.next;
    }
}
