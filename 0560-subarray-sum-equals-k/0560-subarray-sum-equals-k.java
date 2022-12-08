class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
         
        int right=0;
        int ans=0;
        int runningSum=0;
        hm.put(0,1);
        while(right<nums.length)
        {
            runningSum+=nums[right];
            if(hm.containsKey(runningSum-k))
            {
                ans+=hm.get(runningSum-k); 
            }
            hm.put(runningSum,hm.getOrDefault(runningSum,0)+1);
            right++;
        }
        return ans;
    }
}