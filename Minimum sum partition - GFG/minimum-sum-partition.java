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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int sum=0;
	    
	    for(int num: arr)
	    {
	        sum+=num;
	    }
	   
	   sum=sum/2;
	   boolean dp[][] = new boolean[n+1][sum+1];
	   
	   for(int i=0;i<=n;i++)
	   {
	       for(int j=0;j<=sum;j++)
	       {
	           if(i==0 && j==0)
	           {
	               dp[i][j]=true;
	           }
	           else if(i==0)
	           {
	               dp[i][j]=false;
	           }
	           else if(j==0)
	           {
	               dp[i][j]=true;
	           }
	           else
	           {
	               if(j>=arr[i-1])
	               {
	                   dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
	               }
	               else
	               {
	                   dp[i][j]=dp[i-1][j];
	               }
	           }
	       }
	   }
	   
	   int subsetSum=0;
	   for(int i=sum;i>=0;i--)
	   {
	       if(dp[n][i])
	       {
	           subsetSum=i;
	           break;
	       }
	   }
	   sum=0;
	    
	    for(int num: arr)
	    {
	        sum+=num;
	    }
	   int subsetSum2= (sum-subsetSum);
	   int diff = Math.abs(subsetSum2-subsetSum);
	   return diff;
	} 
}
