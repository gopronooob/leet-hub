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
            Node walkerCopy=new Node(walker.val);
            Node next=walker.next;
            walker.next=walkerCopy;
            walkerCopy.next=next; 
            walker=next;            
        }
        
        //copy random pointers to the weaved linkedlist 
        walker=head;
        while(walker!=null)
        {
            Node random=walker.random ==null?null:walker.random.next;
            walker.next.random=random;
            walker = walker.next.next;
        }
        
        walker = head;
        Node newHead = head.next;
        //unweave copy list 
        while(walker != null) {
            Node walkerNew = walker.next;
            walker.next=walkerNew.next;
            walkerNew.next=walker.next==null?null:walker.next.next;
            walker=walker.next;
                     
        }
        return newHead;
        
    }
}