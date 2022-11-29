class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
       // Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    
    public boolean helper(int[] nums, int index,Boolean[] dp)
    {
        
        if(index>=nums.length-1)
        {
            return true;
        }
        if(dp[index]!=null) return dp[index];
        for(int i=1;i<=nums[index];i++)
        {
            if(helper(nums,index+i,dp))
                return dp[index]=true;
        }
        return dp[index]=false;
    }
}