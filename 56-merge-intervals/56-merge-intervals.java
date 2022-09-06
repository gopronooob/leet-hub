class Solution {
    public int[][] merge(int[][] intervals) {
        
        Pair arr[]=new Pair[intervals.length];
        
        for(int i=0;i<intervals.length;i++)
        {
            arr[i]=new Pair(intervals[i][0],intervals[i][1]);
        }
        
        Arrays.sort(arr);
        Stack<Pair> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            //System.out.println(arr[i].st+"  "+arr[i].et);
 
            if(i==0)
            {
                stack.push(arr[i]);
            }
            else
            {
                Pair temp=stack.peek();
                if(temp.et<arr[i].st)
                {
                    stack.push(arr[i]);
                }
                else
                {
                    temp.et=Math.max(temp.et,arr[i].et);
                }
            }
        }
        
        Stack<Pair> temp=new Stack<>();
        
        while(!stack.isEmpty())
        {
            temp.push(stack.pop());
        }
                

        //System.out.println(temp.size());
        
        int ans[][]=new int[temp.size()][2];

        int s = temp.size();        
        for (int i = 0; i < s; i++) {
            Pair p=temp.pop();
            //System.out.println(i+" "+p.st+"  "+p.et);
            ans[i][0]=p.st;
            ans[i][1]=p.et;
            
            
        }
        
        return ans;
    }
    
}

class Pair implements Comparable<Pair> {
    int st;
    int et;
    
    Pair(int i,int j)
    {
        this.st=i;
        this.et=j;
    }
    
    public int compareTo(Pair p)
    {
        if(this.st!=p.st)
        {
            return this.st-p.st;
        }
        else
        {
            return this.et-p.et;
        }
    }
    
    
}