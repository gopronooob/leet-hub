//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        int ans=0;
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                treverse(i,adj,visited,s);
            }
        }
        
        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>(V);
        for(int i=0;i<V;i++)
        {
            reverseAdj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> original=adj.get(i);
            for(int neigh : original)
            {
                reverseAdj.get(neigh).add(i);
            }
        }
        
      //  System.out.println(adj);
//  System.out.println(reverseAdj);
//  System.out.println(s);
        
        while(!s.isEmpty())
        {
            int currentNode=s.pop();
            if(!visited[currentNode])
            {
                //  System.out.println(currentNode+" "+Arrays.toString(visited));

                ans++; 
                reverseTreverse(currentNode,reverseAdj,visited);
            }
            
        }
        return ans;
    }
    
    public void treverse(int index,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> s) {
        if(visited[index]) return;
        
        visited[index]=true;
        for(int neighbor: adj.get(index))
        {
            if(!visited[neighbor])
            {
                treverse(neighbor,adj,visited,s);
            }
        }
        s.push(index);
        
    }
    
    public void reverseTreverse(int index,ArrayList<ArrayList<Integer>> reverseAdj,boolean[] visited) {
        if(visited[index]) return;
        visited[index] = true;
        
        // System.out.println(index+" "+reverseAdj.get(index));
        for(int neighbor: reverseAdj.get(index))
        {
            if(!visited[neighbor]) 
               { reverseTreverse(neighbor,reverseAdj,visited);}
        }
    }
}


