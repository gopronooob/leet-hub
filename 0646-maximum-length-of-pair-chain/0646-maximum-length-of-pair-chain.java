class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int n=pairs.length;
        
        int dp[] = new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++)
        {
            int max=0;
            for(int j=0;j<i;j++)
            {
                
                if(pairs[j][1]<pairs[i][0])
                {
                    if(max<dp[j])
                    {
                        max=dp[j];
                    }
                }
            }
            max+=1;
            dp[i]=max;
            ans=Math.max(ans,max);
        }
        
        return ans;
    }
}