class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        int openParen=n;
        int closeParen=n;
         
        helper(openParen,closeParen,"");
        
        return ans;
    }
    
     void helper(int openCount,int closeCount,String parSoFar)
    {
        if(openCount==0 && closeCount==0)
        {
            ans.add(parSoFar);
            return;
        }
        
        if(openCount>0)
        {
            helper(openCount-1,closeCount,parSoFar+"("); 
        }
          if(openCount<closeCount)
        {
            helper(openCount,closeCount-1,parSoFar+")"); 
        }
        
        
    }
    
}