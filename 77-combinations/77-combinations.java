class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ansSoFar=new ArrayList<>();
        generateCombination(n,k,ansSoFar,1);
        return ans;
        
    }
    
   void generateCombination(int n,int K , List<Integer> ansSoFar,int start)
    {
        if(K==0)
        {
            ans.add(new ArrayList(ansSoFar));
            return;
        }
        
        for(int i=start;i<=n;i++)
        {
            ansSoFar.add(i);
            generateCombination(n,K-1,ansSoFar,i+1);
            ansSoFar.remove(ansSoFar.size()-1);
        }
    }
}