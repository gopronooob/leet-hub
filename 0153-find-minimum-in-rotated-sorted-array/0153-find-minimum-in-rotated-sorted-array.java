class Solution {
    public int findMin(int[] nums) {
        
        int start =0;
        int end=nums.length-1;
        if(end==0) return nums[0];
        
        while(start <= end)
        {
            if(nums[start]<nums[end])
                return nums[start];
            
            int mid = start + (end-start)/2;
            
            if(nums[mid] < nums[(mid-1+nums.length)%nums.length] && nums[mid] < nums[(mid+1)%nums.length])
            {
                return nums[mid];
            }
            else if(nums[start]<=nums[mid])
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return 0;
    }
}