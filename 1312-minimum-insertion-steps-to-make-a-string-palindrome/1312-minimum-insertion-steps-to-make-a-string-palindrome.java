class Solution {
    public int minInsertions(String s) {
        
        String s2= new StringBuffer(s).reverse().toString();
        
        int l1= s.length();
        int l2=s.length();
        
        int dp[][]= new int[l1+1][l1+1];
        
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l1;j++)
            {
                if(s.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return l1-dp[l1][l1];
    }
}