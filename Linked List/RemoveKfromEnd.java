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
class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head == null || head.next == null)
            return null;    // Only One Node
        
        ListNode temp = head;
        int count = 0;
        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }
        //Remove is Head
        if(n == count)
            return head.next;
        
       temp = head;
       int del = count-n;
        for(int i=1;i<del;i++)
            temp = temp.next;
        temp.next = temp.next.next;
        return head;
    }
}