class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ansSoFar=new ArrayList<>();
        Arrays.sort(candidates); 
        getCombination(candidates,target,0,ansSoFar);
        return ans;
    }
    
    void getCombination(int[] candidates , int target, int index,List<Integer> ansSoFar)
    {
        if(target<0)return;
        else if(target==0)
        {
            ans.add(new ArrayList(ansSoFar));
            return;
        }
        
        for(int i=index;i<candidates.length;i++)
        {
         if(i>index && candidates[i]==candidates[i-1])continue;
            ansSoFar.add(candidates[i]); 
            getCombination(candidates,target-candidates[i],i+1,ansSoFar);
            ansSoFar.remove(ansSoFar.size()-1);
        }
    }
}