class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp=new int[nums.length+1];
        
        dp[0]=1;
        int ans=1;
        for(int i=1;i<nums.length;i++ )
        {
            int max=0;
            
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(max<dp[j])
                        max=dp[j];
                }
            }
            
            max+=1;
            dp[i]=max;
            ans=Math.max(ans,max);
        }
        
        return ans;
    }
    
    
}