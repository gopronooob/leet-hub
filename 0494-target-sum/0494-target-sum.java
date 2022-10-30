class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum=0;
        
        if(nums.length == 1){
            if(nums[0] == Math.abs(target))
                return 1;
            else
                return 0;
        }
        
        
        for(int num :nums)
            sum+=num;
        
        if(((sum + target) % 2 == 1) || (target>sum)) return 0;
        
        target=(target+sum)/2;
        
        int[][] dp = new int[nums.length+1][target+1];
        
         for(int i=0;i<=nums.length;i++)
            { 
                    dp[i][0]=1;
            }
        
        for(int i=0;i<=nums.length;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    dp[i][j]=0;
                } 
                else
                {
                    if(j>=nums[i-1] )
                    {
                        dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
                    
            }
        }
        
        
        return dp[nums.length][target];
        
    }
}