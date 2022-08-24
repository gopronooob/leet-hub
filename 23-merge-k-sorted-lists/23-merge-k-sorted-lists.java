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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        
        ListNode merged=null;
        
        for(ListNode l:lists)
        {
            merged=mergeLists(merged,l);
        }
        return merged;
    }
    
private ListNode mergeLists(ListNode list1, ListNode list2) {
    if(list1 == null)
        return list2;
    if(list2==null)
        return list1;
    
    ListNode ans=new ListNode();
    ListNode walker=ans;
    while(list1!=null &&list2 !=null)
    {
        if(list1.val<list2.val)
        {
            walker.next=list1;
            walker=walker.next;
            list1=list1.next;            
        }
        else
        {
            walker.next=list2;
            walker=walker.next;
            list2=list2.next;
        }
        
        if(list1==null)
            walker.next=list2;
        if(list2==null)
            walker.next=list1;
        
    }
    
        return ans.next;
}
}