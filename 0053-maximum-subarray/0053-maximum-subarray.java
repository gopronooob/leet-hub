class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax=Integer.MIN_VALUE;
        int localMax=0;
        for(int i=0;i<nums.length;i++)
        {
             localMax += nums[i];
             if(globalMax<localMax)
             {
                 globalMax=localMax;
             }
            localMax=Math.max(0,localMax);
                 
        }
        return globalMax;
    }
}