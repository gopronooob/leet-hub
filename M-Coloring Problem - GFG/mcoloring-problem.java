//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
        int[] colors = new int[n];
        
        return colorGraph(graph,colors,m,n,0);
    }
    
    public boolean colorGraph(boolean[][] graph,int[] colors,int m ,int n,int index)
    {
        if(index==n)
            return true;
            
        for(int i=1;i<=m;i++)
        {
            if(isValidColor(graph,colors,n,index,i))
            {
                colors[index]=i;
                if(colorGraph(graph,colors,m,n,index+1)) return true;
                colors[index]=0;
            }
        }
        
        return false;
    }
    
    public boolean isValidColor(boolean[][] graph,int[] colors,int n,int index,int toColor)
    {
        for(int i=0;i<n;i++)
            {if(index!=i && graph[index][i] && colors[i]==toColor) return false;
            }
            return true;
    }
}