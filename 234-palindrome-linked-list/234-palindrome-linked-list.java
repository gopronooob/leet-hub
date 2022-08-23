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
    public boolean isPalindrome(ListNode head) {
        
        if (head==null)
            return true;
 
        ListNode fastPointer=head;
        ListNode slowPointer=head;
        while(fastPointer!=null && fastPointer.next != null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
        }
      
        ListNode rev=reverseLinkedList(slowPointer);
        if(rev==null && head !=null || head==null &&  rev!=null )
            return false;
        while(rev!=null && head!=null)
        {
            //System.out.println(rev.val+"  "+head.val);
            if(rev.val!=head.val)return false;
            rev=rev.next;
            head=head.next;
        }
 return true;
}
    
    public static ListNode reverseLinkedList(ListNode point)
    { 
        
       ListNode prev=null;
        ListNode head=point;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
            
            
        }
        
 
        
        return prev;
    }
    
    
}    
   
    