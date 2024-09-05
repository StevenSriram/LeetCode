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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // resultant Addition List
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        // Carry on addition
        int carry = 0;

        /*
            check for any of list is not NULL ( 567 + 89 = 656 )
            also Carry is non ZERO ( 7 + 8 = 15 )
        */
        while(l1 != null || l2 != null || carry != 0)
        {
            // null - 0 value
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            // value1 + value2 + carry
            int sum = v1 + v2 + carry;

            // include Last Next Number
            carry = sum / 10;
            // include Last Number
            sum = sum % 10;

            // add to resultant List
            cur.next = new ListNode(sum);
            cur = cur.next;

            // check for null
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        // return Addition of Linked List
        return dummy.next;
    }
}