class Solution {
    Map<Integer,ArrayList<Integer>> adj;
    int components=0;
    public int makeConnected(int n, int[][] connections) {
        generateList(n,connections);
        boolean[] visited = new boolean[n];
        countComponents(adj,visited);
        
        int redandantEdges=connections.length-((n-1)-(components-1));
        
        //System.out.println(redandantEdges+" "+n+" "+connections.length);
        return (redandantEdges>=components-1)?components-1:-1;
    }
    
    
    void generateList(int n, int[][] connections)
    {
        adj= new HashMap<>();
        
        for(int[] edge:connections)
        {
            ArrayList al1=adj.getOrDefault(edge[0],new ArrayList<Integer>());
            al1.add(edge[1]);
            adj.put(edge[0],al1);
            
            ArrayList al2=adj.getOrDefault(edge[1],new ArrayList<Integer>());
            al2.add(edge[0]);
            adj.put(edge[1],al2);
        }
        
    }
    
    void countComponents(Map<Integer,ArrayList<Integer>> adj,boolean[] visited)
    {
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                treverseGraph(adj,i,visited);
                components++;
            }
        }
    }
    
    void treverseGraph(Map<Integer,ArrayList<Integer>> adj,int index,boolean[] visited)
    {
        if(visited[index])return;
        visited[index]=true;
        for(int key: adj.getOrDefault(index,new ArrayList<Integer>()))
            treverseGraph(adj,key,visited);
    }
    
}