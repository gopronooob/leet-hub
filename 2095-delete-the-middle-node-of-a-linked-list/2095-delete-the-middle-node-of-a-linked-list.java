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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        ListNode dummy=new ListNode();

        dummy.next=head;
        ListNode fast=head;
        ListNode slow=dummy;
        
        
        while(fast!=null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
        }
            
       // slow.val=slow.next.val;
        slow.next=slow.next.next;
        
        return dummy.next;
        
    }
}