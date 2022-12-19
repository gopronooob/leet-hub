class Solution {
    public int maxSubArray(int[] nums) {
        
        int globalMax=Integer.MIN_VALUE;
        int localMax=0;
        for(int i=0;i<nums.length;i++)
        {
            localMax+=nums[i];
            globalMax=Math.max(localMax,globalMax);
            localMax=Math.max(0,localMax);                
            
        }
        return globalMax;
    }
}