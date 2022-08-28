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
        
        if(l1==null) 
            return l2;
        if(l2==null)
            return l1;
        ListNode ans=null;
        ListNode walker=ans;
        int carry=0;
        
        while(l1!=null &&l2!=null)
        {
            
            int sum=l1.val+l2.val+carry;
            carry=(sum<10)?0:1;
            sum=sum%10;
            if(ans==null)
            {
                ans=new ListNode(sum); 
                walker=ans;
            }
            else
            {
                ListNode temp=new ListNode(sum); 
                walker.next=temp;
                walker=walker.next;
            }
            l1.val=sum;
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null)
        {
            int sum=l1.val+carry;
            carry=(sum<10)?0:1;
            sum=sum%10;
            ListNode temp=new ListNode(sum); 
            l1=l1.next;
            walker.next=temp;
            walker=walker.next;            
            
        }
        while(l2!=null)
        {
            int sum=l2.val+carry;
            carry=(sum<10)?0:1;
            sum=sum%10;
            ListNode temp=new ListNode(sum); 
            l2=l2.next;
            walker.next=temp;
            walker=walker.next;            
            
        }  
        if(carry!=0)
        {
            ListNode temp=new ListNode(carry);
            walker.next=temp;
            
        }
        return ans;
    }
}