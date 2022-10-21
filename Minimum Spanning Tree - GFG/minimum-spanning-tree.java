//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans = 0;
        int[] parent = new int[V+1];
        
        for(int i=0;i<V;i++)
        {
            ArrayList<ArrayList<Integer>> edges= adj.get(i);
            for(ArrayList<Integer> edge : edges)
                pq.add(new Pair(i,edge.get(0),edge.get(1)));
        }
        
        Arrays.fill(parent,-1);
        while(!pq.isEmpty())
        {
            Pair curr= pq.remove();
            int srcParent = getParent(curr.src,parent);
            int destParent = getParent(curr.dest,parent);
            
            if(srcParent!=destParent)
            {
                ans=ans+curr.weight;
                
                parent[srcParent]=destParent;
            }
        }
        
        return ans;
    }
    
static int getParent(int node,int [] parents){
        if (parents[node]<0) return node;
        
        return  getParent(parents[node],parents);
    }
    
}


class Pair implements Comparable<Pair>
{
    int src;
    int weight;
    int dest;
    public Pair(int src,int dest,int weight)
    {
        this.src=src;
        this.weight=weight;
        this.dest=dest;
    }
    
    public int compareTo(Pair other)
    {
        return this.weight-other.weight;
    }
    
    public String toString()
    {
        return "src "+this.src +" dest "+ +this.dest+" weight "+weight;
    }
}
