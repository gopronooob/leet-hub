class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax=Integer.MIN_VALUE;
        int localMax=0;
        
//         for(int i=0;i<nums.length;i++)
//         {
//              localMax += nums[i];
//              if(globalMax<localMax)
//              {
//                  globalMax=localMax;
//              }
//             localMax=Math.max(0,localMax);
                 
//         }
//         return globalMax;
        
        int[][] dp= new int[nums.length+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(nums,0,0,dp);
        
    }
    
    public static int helper(int[] nums,int index,int flag,int[][] dp)
    {
        if(nums.length<=index)
        {
            return (flag==1)?0: Integer.MIN_VALUE ;
        }
        
        if(dp[index][flag]!=-1) return dp[index][flag];
        
        if(flag==1)
        {
            return dp[index][flag]=Math.max(helper(nums,index+1,1,dp)+nums[index],0);
        }
        return dp[index][flag]=Math.max(helper(nums,index+1,1,dp)+nums[index],helper(nums,index+1,0,dp)); 
    }
    
     
       
    
}