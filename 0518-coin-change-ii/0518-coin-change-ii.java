class Solution {
    public int change(int amount, int[] coins) {
        
        
        
         int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    dp[i][j]=0;
                }
                else if(j==0)
                {
                    dp[i][j]=1;
                }
                else 
                {
                    if(j>=coins[i-1])
                    {
                        dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                    }
                    else 
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }            
        }        
        //if(dp[coins.length][amount]==0) return 0 ; else
             return dp[coins.length][amount];
    
    }
}