class Solution {
        Stack<Integer> stack=new Stack<>(); 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();        
        boolean[] visited=new boolean[numCourses];
        
        // for(int[] dependency : prerequisites)
        // {
        //     List<Integer> al = graph.getOrDefault(dependency[0],new ArrayList<Integer>());
        //     al.add(dependency[1]);
        // }

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = graph.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            graph.put(src, lst);
        }
        
        if(isCircular(graph,visited)) return new int[0];
        
        visited = new boolean[numCourses];
        
        topologicalSort(graph,visited);
        int[] ans = new int[numCourses];
        // for(int i=0;i<stack.size();i++)
        //     ans[i]=stack.pop();
                int loop=0;
        while(!stack.isEmpty())
        {
            ans[loop++]=stack.pop();
        }
        return ans;
         
    }
    
    boolean isCircular(Map<Integer,List<Integer>> graph, boolean[] visited)
    {
        for(int i=0;i<visited.length;i++)
        {
            if(circularHelper(graph,i,visited)) return true;
                           
        }
        return false;
    }
    
    public boolean circularHelper(Map<Integer,List<Integer>> graph,int index,boolean[] visited)
    {
        if(visited[index]) return true;
        
        visited[index]=true;
        if(graph.get(index)!=null) 
        {for(int neighbor: graph.get(index))
        {
            if(circularHelper(graph,neighbor,visited)) return true;
        }
        }
        
        visited[index]=false;
        return false;
    }
    
    public void topologicalSort(Map<Integer,List<Integer>> graph,boolean[] visited)
    {
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
                dfs(graph,visited,i);
        }
    }
    
    public void dfs(Map<Integer,List<Integer>> graph, boolean[] visited,int index)
    {
        if(visited[index]) return;
        
        visited[index]= true;
        if(graph.get(index)!=null) {
        for(int neighbor: graph.get(index))
        {
            dfs(graph,visited,neighbor);
        }}
        stack.push(index);
    }
}