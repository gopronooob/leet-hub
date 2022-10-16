class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> ansSoFar = new ArrayList<>();
        getSubSet(nums,ans,ansSoFar,0);
        return ans;
    }
    
    void getSubSet(int[] nums,List<List<Integer>> ans,List<Integer> ansSoFar,int index)
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList(ansSoFar));
            return;
        }
        
        getSubSet(nums,ans,new ArrayList(ansSoFar),index+1);
        ansSoFar.add(nums[index]);
        getSubSet(nums,ans,new ArrayList(ansSoFar),index+1);
        
    }
}