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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode walker=head;
      
        while(walker!=null && walker.next!=null)
        {
            if(walker.val==walker.next.val)
                walker.next=walker.next.next;
            else
                walker=walker.next;
        }
        return head;
    }
}