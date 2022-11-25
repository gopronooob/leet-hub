//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static double mod=1e9+7;
    public long countFriendsPairings(int n) 
    { 
       long[] dp=new long[n+1];
       
       return countPair(n,dp);
    }
    
    
    public static long countPair(int n,long[] dp)
    {
        if(n<=1)
        {
            return 1;
        }
        
        if(dp[n]!=0)
            return dp[n];
             long single = countPair(n-1,dp);
        long paired = (n-1)*countPair(n-2,dp);

        dp[n]  = (long)((single + paired)%mod);
        
        return dp[n];
    }
}    
