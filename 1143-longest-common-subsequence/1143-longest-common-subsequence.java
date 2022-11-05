class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return helper(text1,text2,text1.length(),text2.length(),dp);
    }
    
    public int helper(String text1,String text2,int size1,int size2,int[][] dp)
    { 
        
        for(int i=1;i<=size1;i++)
        {
            for(int j=1;j<=size2;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    return dp[size1][size2];
    }
    
}