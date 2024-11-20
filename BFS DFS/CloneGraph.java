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
    // Clone Table
    Map<Node, Node> oldToNew;

    public Node cloneGraph(Node node) 
    {
        if(node == null)
            return null;

        // Mapping of { Original Node : Cloned Node }
        oldToNew = new HashMap<>();

        // Depth First Search to Clone Ecah Node
        return dfs(node);
    }

    public Node dfs(Node node)
    {
        // Node already Cloned - return the clone
        if(oldToNew.containsKey(node))
        {
            return oldToNew.get(node);
        }

        // Create Clone of cur Node - add to Clone Table
        Node clone = new Node(node.val);
        oldToNew.put(node, clone);

        // traverse Adj of cur Node
        for(Node nei : node.neighbors)
        {
            // add neighbors to Cloned Node
            clone.neighbors.add( dfs(nei) );
        }

        // DFS ends : head Node
        return clone;
    }
}