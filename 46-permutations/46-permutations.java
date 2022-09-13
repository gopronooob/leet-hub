class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ansSoFar=new ArrayList<>();
        backTrack(ansSoFar,nums);
        return ans;
    }
    
    void backTrack(List<Integer> ansSoFar,int[] nums)
    {
        if(ansSoFar.size()==nums.length)
        {
            ans.add(new ArrayList(ansSoFar));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(ansSoFar.contains(nums[i]))continue;
            
             ansSoFar.add(nums[i]);
             backTrack(ansSoFar,nums);
             ansSoFar.remove(ansSoFar.size()-1);
            
        }
    }
}