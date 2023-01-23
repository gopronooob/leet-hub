class Solution {
    public int largestRectangleArea(int[] heights) {
        int area=0;
        int n=heights.length;
        int[] nsl=new int[n];
        int[] nsr=new int[n];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >=heights[i])
            {
                stack.pop();
            }
            nsl[i]=(stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) 
            {
                stack.pop();
            }
            nsr[i]=(stack.isEmpty())?n:stack.peek();
            stack.push(i);
        }
        for(int i=0;i<n;i++)
        {
            //System.out.println(i+" "+nsr[i]+" "+nsl[i]);
            area=Math.max(area,(nsr[i]-nsl[i]-1)*heights[i]);
        }
        return area;
        
        
    }
}