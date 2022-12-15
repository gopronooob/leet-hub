class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end = matrix.length-1;
        int colSize = matrix[0].length-1;
        while(start <= end)
        {
            int mid=start+(end-start)/2;
            
            if(matrix[mid][0]==target)
            {
                return true;
            }
            else if(matrix[mid][0]<=target && matrix[mid][colSize] >= target)
            {
                return binSearch(matrix[mid],target);
            }
            else if(matrix[mid][0]>target )
            {
                end = mid-1;
            }
            else 
            {
                start=mid+1;
            }
        }
        return false;
    }
    
    
    public boolean binSearch(int[] nums,int target)
    {
         int start=0;
        int end = nums.length-1;
        
         while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
            {
                return true;
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
        
        return false;
        
    }
}