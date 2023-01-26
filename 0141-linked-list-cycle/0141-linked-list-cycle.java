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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
        {
            return false;
        }

        ListNode fastWalker=head.next;
        ListNode slowWalker=head;
        while(slowWalker!=fastWalker)
        {
            if(fastWalker==null || fastWalker.next==null)
            {
                return false;
            }
            slowWalker=slowWalker.next;
            fastWalker=fastWalker.next.next;
        }
        return true;
    }
}