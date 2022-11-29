class Solution {
    public int jump(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    
    public int helper(int[] nums,int index,int[] dp)
    {
        if(index>=nums.length-1)
            return 0;
        if(dp[index]!=-1)return dp[index];
        int ans=Integer.MAX_VALUE-1;
        for(int i=1;i<=nums[index];i++)
        {
            int tempAns= helper(nums,index+i,dp)+1;
            ans=Math.min(ans,tempAns); 
        }
        return dp[index]=ans;
    }
}