//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int ans=0;
    static int matrixMultiplication(int N, int arr[])
    {
        int leftWin=1;
        int rightWin=N-1;
         int[][] dp= new int[N+1][N+1];
        return helper(arr,leftWin,rightWin,dp);
    }
    
    static int helper(int[] arr,int leftWin,int rightWin,int[][] dp)
    {
        if(leftWin>= rightWin) return 0;
        if(dp[leftWin][rightWin]!=0) return dp[leftWin][rightWin];
        int min = Integer.MAX_VALUE; 
        
        for(int k=leftWin;k<rightWin;k++)
        {
            int tempAns=helper(arr,leftWin,k,dp)+
                        helper(arr,k+1,rightWin,dp)+
                        arr[leftWin-1]*arr[k]*arr[rightWin];
            min=Math.min(min,tempAns);
        }
        dp[leftWin][rightWin] = min;
        return min;
    }
}