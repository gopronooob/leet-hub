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
      int num1=0,num2=0,sum=0,carry=0;
        ListNode ans=new ListNode();
        ListNode dummy=ans;
       
        while((l1!=null || l2!=null) || carry==1)
        {
            num1=(l1!=null)?l1.val:0;
            num2=(l2!=null)?l2.val:0;
            
              sum=num1+num2+carry;
            ans.next=new ListNode(sum%10);
            ans=ans.next;
            carry=sum/10;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        } 
        return dummy.next;
    }
}