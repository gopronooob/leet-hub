//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        
        if(S1==null || S2==null || n==0 || m==0) return 0;
        int[][] dp= new int[n+1][m+1];
        
        
       //   helper(S1,S2,n-1,m-1,dp);
      
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }


         int max = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    
    
    
    
    int helper(String S1, String S2, int n, int m,int[][] dp)
    {
        if(n<0 || m< 0) return 0;
        
          helper(S1,S2,n,m-1,dp); 
          helper(S1,S2,n-1,m,dp);
        if(dp[n][m]!=0) return dp[n][m];
        
        if(S1.charAt(n)==S2.charAt(m))
        {
            dp[n][m]=1+helper(S1,S2,n-1,m-1,dp);
        }
        else
        {
            dp[n][m]=0;
        }
        
        return dp[n][m];
    }
}