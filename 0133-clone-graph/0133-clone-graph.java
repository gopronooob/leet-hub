/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        
        Map<Node,Node> visited = new HashMap<>();
        Node clone=clonner(node,visited);
        return clone;
    }
    
    Node clonner(Node node, Map<Node,Node> visited)
    {
        if(visited.containsKey(node))
        {
            return visited.get(node);
        }
        
        Node clonned = new Node(node.val);
        visited.put(node,clonned);
        
        for(Node n: node.neighbors)
        {
            clonned.neighbors.add(clonner(n,visited));
        }
        
        return clonned;
    }
}