class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1 && K==1)
        {
            return 0;
        }
        int length= (int)(Math.pow(2,N-1));
       if(K>length/2)
        return 1-kthGrammar(N-1,K-(length/2));
       else 
           return kthGrammar(N-1,K);
        
    }
}