class Solution {
    public int findTheWinner(int n, int k) {
        
        if(n==0|| k==0) return 0;
        ArrayList<Integer> players =new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            players.add(i+1);
        }
            
        return winnerFinder(n,k-1,players,0);        
    }
    
    int  winnerFinder(int n,int k,ArrayList<Integer> players,int index)
    {
        if(1==players.size())
        {            
            return players.get(0);
        }   
        index=(index+k)%players.size(); 
        players.remove(index);
       return winnerFinder(n-1,k,players,index); 
           
    }
}