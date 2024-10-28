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
    public ListNode detectCycle(ListNode head) 
    {
        // Empty List | One Node - No Cycle
        if(head == null || head.next == null)    
            return null;

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
            {
                /* Fast - Slow both points to where cycle exists
                
                        3 -> 2 -> 0 -> -4  - |  => Fast , Slow
                              ^ -  -  -  -  - 

                    Traverse Linked List from head and slow,  
                    if head and slow meets that it is Start of Loop
                */
                // fast is Head
                fast = head;

                // head, slow meets
                while(fast != slow)
                {
                    fast = fast.next;
                    slow = slow.next;
                }
                /* Starting of Loop */
                return fast;
            }
        }

        // No Cycle exists
        return null;
    }
}