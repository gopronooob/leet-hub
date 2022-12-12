class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        
        int start=0;
        int end=nums.length-1;
        ans[0]=findFirst(nums,start,end,target);
        ans[1]=findLast(nums,start,end,target);
        
        return ans;
    }
    
    public static int findFirst(int[] nums,int start,int end,int target)
    {
        int ans=-1;
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
            {
                ans=mid;
                end=mid-1;
            }
            else if(nums[mid]<target)
            {
               start=mid+1;
            }
            else 
            {
                end=mid-1;
            }
        }
        
        return ans;
    }
    
    
    public static int findLast(int[] nums,int start,int end,int target)
    {
        int ans=-1;
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
            {
                ans=mid;
                start=mid+1;
            }
            else if(nums[mid]<target)
            {
               start=mid+1;
            }
            else 
            {
                end=mid-1;
            }
        }
        
        return ans;
    }
}