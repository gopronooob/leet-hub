class Solution {
    public int maxProfit(int[] prices) {
        
        int[][][] dp = new int[prices.length+1][2][3];
        for(int i=0;i<=prices.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return helper(prices,0,1,2,dp);
        
    }
    
    public static int helper(int[] nums, int index, int buyFlag, int chanceCount, int[][][] dp)
    {
        
        if(index==nums.length || chanceCount == 0) return 0;
        
        if(dp[index][buyFlag][chanceCount]!=-1) return dp[index][buyFlag][chanceCount];
        
        int ans=0;
        
        if(buyFlag==1)
        {
            int buy = helper(nums,index+1,0,chanceCount,dp)-nums[index];
            int doNotBuy =  helper(nums,index+1,1,chanceCount,dp);
            ans=Math.max(buy,doNotBuy);
        }
        else
        {
            int sell=  helper(nums,index+1,1,chanceCount-1,dp)+nums[index];
            int doNottSell=  helper(nums,index+1,0,chanceCount,dp);
            ans=Math.max(sell,doNottSell);
        }
        
        return dp[index][buyFlag][chanceCount]= ans;
    }
}