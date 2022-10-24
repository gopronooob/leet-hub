//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        
    /*    int[] cost= new int[n];
        Arrays.fill(cost,999999);
        cost[0] = 0;
        for(int i=1;i<n;i++){
        for(int[] edge : edges)
        {
            int src= edge[0];
            int dest = edge[1];
            int weight = edge[2];
            
            cost[dest]= Math.min(cost[dest],weight+cost[src]);
        }
        }
           
        for(int[] edge : edges)
        {
            int src= edge[0];
            int dest = edge[1];
            int weight = edge[2];
            
            if(cost[dest]>weight+cost[src]) return 1;
        }
        
        return 0;*/
        
        
                int[] costs = new int[n];
        Arrays.fill(costs,99999);
        costs[0]=0;
        int[] temp=costs.clone();
        
        for(int i=1;i<n;i++)
        {
            //temp=new int[n];
            for(int[] edge: edges )
            {
                int source= edge[0];
                int dest= edge[1];
                int cost = edge[2];
                
                if(temp[dest]> cost+costs[source])
                {
                    temp[dest]=cost+costs[source];
                }
            } 
            costs=temp.clone();
        }
        
        for(int[] edge: edges )
            {
                int source= edge[0];
                int dest= edge[1];
                int cost = edge[2];
                
                if(temp[dest]> cost+costs[source])
                {
                   return 1;
                }
            } 

        return 0;
    }
}