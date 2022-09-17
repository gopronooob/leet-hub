class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ansSoFar=new ArrayList<>();
        backTrack(ansSoFar,nums,new boolean[nums.length]);
        return ans;
    }
    
    void backTrack(List<Integer> ansSoFar,int[] nums, boolean [] used)
    {
        if(ansSoFar.size()==nums.length)
        {
            ans.add(new ArrayList(ansSoFar));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true;  
             ansSoFar.add(nums[i]);
             backTrack(ansSoFar,nums,used);
             ansSoFar.remove(ansSoFar.size()-1);
            
            used[i] = false;  
            
        }
    }
}