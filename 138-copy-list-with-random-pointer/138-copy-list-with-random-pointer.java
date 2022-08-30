/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null)
        {
            return head;
        }
        
        Node walker=head;
        
        //create a weave LinkedList
        while(walker!=null)
        {
            Node temp=new Node(walker.val);
            temp.next=walker.next;
            walker.next=temp;
            walker=temp.next;
        }

        //copy random pointers to the weaved linkedlist 
        walker=head;
        while(walker!=null && walker.next!=null )
        {
            Node random=walker.random ==null?null:walker.random.next;
            walker.next.random=random; 
            walker=walker.next.next;
        }
        
        //unweave copy list 

        Node ans=head.next;
        walker=head;
        Node walker2=head.next;
        while(walker!=null)
        {            
            walker.next=walker.next.next;
            walker2.next=walker2.next==null?null:walker2.next.next;
            walker=walker.next;
            walker2=walker2.next;
        }
        return ans;
    }
}