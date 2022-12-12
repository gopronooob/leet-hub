class Solution {
    public boolean check(int[] nums) {
        int rotateCount =0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>nums[(i+1)%nums.length])
                rotateCount++;
        }
        
        return (rotateCount>1)? false :true;
    }
}