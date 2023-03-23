class BrowserHistory {
 
    
    Node current;
    
    public BrowserHistory(String homepage) {       
        current= new Node(homepage);
        
        
        
    }
    
    public void visit(String url) {
        Node newUrl=new Node(url);
        current.next=newUrl;
        newUrl.prev=current;
        current = newUrl;
      
    }
    
    public String back(int steps) { 
         
        for(int i=0;i<steps;i++)
        {
            if(current.prev!=null)
             current=current.prev;            
        }
          
        return current==null?null:current.data;
    }
    
    public String forward(int steps) { 
         
        for(int i=0;i<steps;i++)
        {
            if(current.next!=null)
                current=current.next;            
        }
          
        return current==null?null:current.data;
    }
}


public class Node {
    String data;
    Node prev;
    Node next;
    
    public Node(String data)
    {
        this.data=data;
    }
    
        
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */