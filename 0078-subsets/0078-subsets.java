class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();        
        List<Integer> ansSoFar = new ArrayList<>();
        
        getSubset(ans,ansSoFar,nums,0);
        
        return ans;
        
    }
    
    
    void getSubset(List<List<Integer>> ans,List<Integer> ansSoFar,int[] nums , int index)
    {
        
        if(index==nums.length)
        {
            ans.add(ansSoFar);
            return;
        }
        
        getSubset(ans,new ArrayList(ansSoFar),nums,index+1);
        ansSoFar.add(nums[index]);
        getSubset(ans,new ArrayList(ansSoFar),nums,index+1);
    }
    
}