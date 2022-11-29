//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int K = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumPairWithDifferenceLessThanK(arr, N, K));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution { 
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        // Your code goes here 
        int[] dp = new int[N+1];
        for(int i=0;i<=N;i++)
            dp[i]=-1;
        Arrays.sort(arr);
        return helper(arr,N,K,dp);

    }
    
    public static int helper(int[] arr,int index,int K ,int[] dp)
    {
        if(index<=1) return 0;
        if(dp[index]!=-1) return dp[index];
        
        if(arr[index-1]-arr[index-2]<K)
        {
             dp[index]= Math.max(arr[index-1]+arr[index-2]+helper(arr,index-2,K,dp),helper(arr,index-1,K,dp));
             return dp[index];
        }
        
            dp[index]=helper(arr,index-1,K,dp);
             return dp[index];
    }
    
}
