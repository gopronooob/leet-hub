class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return helper(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    
    public int helper(String text1,String text2,int size1,int size2,int[][] dp)
    {
        if(size1<0 || size2<0)
        {
            return 0;
        }
        if(dp[size1][size2]!=0) return dp[size1][size2];
        
        if(text1.charAt(size1)==text2.charAt(size2))
        {
            dp[size1][size2]=1+helper(text1,text2,size1-1,size2-1,dp);
             
        }
        else
        {
            dp[size1][size2]= Math.max(helper(text1,text2,size1,size2-1,dp),helper(text1,text2,size1-1,size2,dp));
        }
    return dp[size1][size2];
    }
    
}