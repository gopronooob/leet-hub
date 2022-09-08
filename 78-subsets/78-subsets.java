class Solution {
    
      List<List<Integer>> output = new ArrayList();
      
    public List<List<Integer>> subsets(int[] nums) {
        
         solve(0,nums,new ArrayList<Integer>());
        return output;
    }
    
    public void solve(int p, int[] nums, List<Integer> pre){
     
        if(p==nums.length)
        {
            output.add(pre);
            return;
        }
        
        List pre1=new ArrayList(pre);
        pre1.add(nums[p]);
        List pre2=new ArrayList(pre);       
        
        solve(p+1,nums,pre2);
        solve(p+1,nums,pre1);
        
    }
}