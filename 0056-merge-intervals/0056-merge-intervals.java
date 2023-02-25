class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length<=1)
            return intervals;
        
     Pair[] pairArr = new Pair[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            pairArr[i]=new Pair(intervals[i][0],intervals[i][1]);
        }
        
        Arrays.sort(pairArr);
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(i==0)
            {
                stack.push(pairArr[i]);
            }
            else            
            {
                Pair temp= stack.peek();
                if(temp.et<pairArr[i].st)
                {
                    stack.push(pairArr[i]);
                }
                else
                {
                    temp.et=Math.max(pairArr[i].et,temp.et);
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