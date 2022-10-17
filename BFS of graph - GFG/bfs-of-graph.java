//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(adj==null || adj.size()==0)return ans;
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] visited = new boolean[V];
         
            //System.out.println("loop of "+i);
            q.add(0);
            while(!q.isEmpty())
            {
                Integer vertices=q.remove();
                if(!visited[vertices])
                {
                //System.out.println("vertices of "+vertices+" "+visited[vertices]);
                    ans.add(vertices);
                    visited[vertices]=true;
                }
                for(Integer connectedNode:adj.get(vertices))
                    {
                        if(!visited[connectedNode])
                            q.add(connectedNode);
                    }
                   
            }  
        return ans;
    }
}