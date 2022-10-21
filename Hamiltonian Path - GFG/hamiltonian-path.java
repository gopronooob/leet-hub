//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        boolean[] visited = new boolean[N+1];
        HashSet<Integer> visitedSet = new HashSet<>();
        boolean flag=false;

        ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=N;i++)

        {

            adj.add(new ArrayList<Integer>());

        }

        for(int i=0;i<M;i++) 
        {  
            int x=Edges.get(i).get(0)-1; 
            int y=Edges.get(i).get(1)-1; 
            adj.get(x).add(y); 
            adj.get(y).add(x);

        }


        for(int i=0;i<N;i++){
             if(checkHamiltonaianPath(adj,visitedSet,i,1,N)) return true;
            visited = new boolean[N+1];
             }
       //  System.out.println("false");
         return false;
    }
    
    boolean checkHamiltonaianPath(ArrayList<ArrayList<Integer>> Edges,HashSet<Integer> visitedSet,int index,int count,int size)
    {
        if(count == size ) return true;
       // System.out.println(size+" "+index+" " + count+" "+visitedSet);
        visitedSet.add(index);
        for(int neighbor: Edges.get(index))
        {
            if(!visitedSet.contains(neighbor))
                if (checkHamiltonaianPath(Edges,visitedSet,neighbor,count+1,size)) return true;
        }
        visitedSet.remove(index);
        return false;
    }
} 