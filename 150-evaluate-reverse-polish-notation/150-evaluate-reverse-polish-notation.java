class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Long> stack=new Stack<>();
        long ans=0;
        for(String token:tokens)
        {
            long num1=0;
            long num2=0;
            if(token.equals("+"))
            {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num1+num2);
            }
            else if(token.equals("-")) 
            {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2-num1);
            }
            else if(token.equals("*"))
            {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2*num1);
            }
            else if(token.equals("/"))
            {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2/num1);
            }
            else
            {
                stack.push(Long.parseLong(token));
            }
                
        }
        
        return (stack.peek()).intValue();
    }
}