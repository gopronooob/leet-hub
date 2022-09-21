class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
   
        List<Integer> ansSoFar =new ArrayList<>();
        generateCombinations(candidates,0,target,ansSoFar);
        
        return ans;
        
        
    }
    
    void generateCombinations(int[] candidate,int index,int target,List<Integer>  ansSoFar)
    {
        if(target<0)return;
        else if(0==target)
        {
            ans.add(new ArrayList(ansSoFar));
            return;
        }
        for(int i=index;i<candidate.length;i++)
        {
            ansSoFar.add(candidate[i]);
            generateCombinations(candidate,i,target-candidate[i],ansSoFar);
            ansSoFar.remove(ansSoFar.size()-1);
        }
    }
    
}