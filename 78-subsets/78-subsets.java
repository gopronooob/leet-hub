class Solution {
        List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ansSoFar = new ArrayList<>();
        addSubset(nums,ansSoFar,0);
        return ans;
        
    }
    public void addSubset(int[] nums,List<Integer> ansSoFar,int index)
    {
        if(index==nums.length)
        {
            ans.add(ansSoFar);
            return;
        }
        List<Integer> pre1=new ArrayList(ansSoFar);
        pre1.add(nums[index]);
        List<Integer> pre2=new ArrayList(ansSoFar);
        addSubset(nums,pre2,index+1);
        addSubset(nums,pre1,index+1);
    }
    
}