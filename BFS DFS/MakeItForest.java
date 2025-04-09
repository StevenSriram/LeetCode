public class Solution
{
  int[] parent;
  
  int minCycleEdge;
  
  public int find(int i)
  {
      // Dis-joint of Node it Itself 
      if(i == parent[i])
      {
        // return cur Set
        return i;
      }
      
      /* 
        Optimization : 
            find Dis-joint of Parent and set it here
      */
      parent[i] = find(parent[i]);
    
      // return Parent's Dis-joint Set
      return parent[i];
  }
  
  public void union(int u, int v)
  {
      // find Parent(dis-joint) of U and V
      int rootU = find(u);
      int rootV = find(v);
      
      // both belongs to Different Sets
      if(rootU != rootV)
      {
          // add U -> V 's Dis-joint set
          parent[rootU] = rootV;
          
          /*
              Instead, of adding all nodes belong to Dis-joint of U 
                to Dis-joint V at Once (Increase Time Complexity)
                
              Update Dis-joint when find Parent of Nodes
          */
      }
      
      // Cycle Formed
      else
      {
          // Remove this Edge
          minCycleEdge++;
      }
  }
  
  public int makeItForest(int V, int[][] edges)
  {
      // Parent : tracks Dis-Joint Sets
      parent = new int[V];
      
      // Intitally, each on it own Disjoint set 
      for(int i=0; i<V; i++)
        parent[i] = i;
        
      // for each Edges
      for(int[] ed : edges)
      {
          // 1 - based Index
          int u = ed[0] - 1;
          int v = ed[1] - 1;
          
          // Joint both Nodes
          union(u, v);
      }
      
      return minCycleEdge;
  }
}