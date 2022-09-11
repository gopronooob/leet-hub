class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null)
            return ans;
        Arrays.sort(nums);
        List<Integer> ansSoFar=new ArrayList<>();
        int size=nums.length;        
        addSubSet(nums,ansSoFar,0);
        return ans;
    }
    
    void addSubSet(int[] nums ,List<Integer> ansSoFar, int index)
    {
        if(index>=nums.length)
        {
            ans.add(ansSoFar);
            return;
        }
        
        int num=nums[index];
        List<Integer> ansSoFar1=new ArrayList(ansSoFar);
        ansSoFar1.add(num);        
        addSubSet(nums,ansSoFar1,index+1);
        
        while(index<nums.length-1 && nums[index]==nums[index+1])
        {
            index++;
        }
        
        addSubSet(nums,new ArrayList(ansSoFar),index+1);
    }
}