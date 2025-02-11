class Solution {
    public void dfs(int[][] isConnected, int V, boolean[] visited, int city)
    {
        // mark as Visited
        visited[city] = true;

        // iterate each Vertices
        for(int i=0; i<V; i++)
        {
            // path Exits and not Visited
            if(isConnected[city][i] == 1 && !visited[i])
            {
                // DFS - connect Components
                dfs(isConnected, V, visited, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        // No. of vertices
        int V = isConnected.length;

        boolean[] visited = new boolean[V];

        // No. of Connected Componenets - City
        int noComponents = 0;

        // iterate all vertices
        for(int i=0; i<V; i++)
        {
            // not Visited
            if(!visited[i])
            {
                // count Components
                noComponents++;

                // Depth First Search from curIdx
                dfs(isConnected, V, visited, i);
            }
        }

        return noComponents;
    }
}