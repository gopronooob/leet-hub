class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;

        int start=0;
        int end = nums.length-1;
        if(end==0)
            return (nums[end]==target)?  0:-1;
        
        int pivot=0;        
        while(start<=end)
        {
            int mid = start + (end -start)/2;
            
            if(nums[start]<nums[end])
            {
                pivot = start;
                break;
            }
            else if(nums[mid]==target)
            {
                return mid;                
            }
            else if(nums[mid]<nums[(mid-1+nums.length)%nums.length] && nums[mid] < nums[(mid+1)%nums.length])
            {
                pivot=mid;
                break;
            }
            else if(nums[mid]<nums[start])
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
            
        }
        
        
    if(nums[n-1]<target)
        {
            return binSearch(nums,0,pivot,target);
        }
        else
        {
            return binSearch(nums,pivot,n-1,target);
        }
        
    }
    
    
    public static int binSearch(int []nums,int start,int end,int target)
    {
        

        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
           // System.out.println(start+" "+end+" "+target);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return -1;
    }
}