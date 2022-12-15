//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int i=0;
    	int j=n-1;
    	
    	while(i!=j)
    	{
    	    if(M[i][j]==1) 
    	    {
    	        i++; //i knows j so i is not celebrity 
    	    }
    	    else
    	    {
    	        j--; // i does not know j so j is not celebrity 
    	    }
    	}
    	
    	for(int k=0;k<n;k++)
    	{
    	    if(M[i][k]==1) return -1; //i knows someone so not celeb 
    	    if(k!=i && M[k][i]==0) return -1; // someone does not know i so not a celeb
    	}
    	
    	return i;
    }
}