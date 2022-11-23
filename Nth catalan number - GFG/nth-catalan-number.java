//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        
        BigInteger[] dp = new BigInteger[n+1];
        
        dp[0]= BigInteger.valueOf(1);
        if(n>=1)
        dp[1]= BigInteger.valueOf(1);
        for(int i=2;i<=n;i++)dp[i]=BigInteger.ZERO;
        for(int i=2;i<=n;i++)
        {
            
            for(int j=0,k=i-1;j<n && k>=0;j++,k--)
                {
                    dp[i]=dp[i].add(dp[j].multiply(dp[k]));
                }
        }
        
        return dp[n];
    }
}