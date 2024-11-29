class Solution
{
    List<Integer>[] adjList;

    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        // Create Adjacency List
        adjList = new List[n];

        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        // take each Edge add to Lsit
        for(int[] edg : edges)
        {
            int u = edg[0] , v = edg[1];

            // Undirected Graph
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // Breadh First Search
        return bfsPathExits(source, destination);
    }

    public boolean bfsPathExits(int src, int dest)
    {
        // Src equals to Dest
        if(src == dest)
            return true;

        // Visited Array
        boolean[] visited = new boolean[adjList.length];

        // Queue for BFS
        Queue<Integer> q = new ArrayDeque<>();

        // mark Visited - add Src to Queue
        visited[src] = true;
        q.offer(src);

        // Queue - not Empty
        while(!q.isEmpty())
        {
            // remove from Queue
            int u = q.poll();

            // check Neighbors - not Visited
            for(int v : adjList[u])
            {
                if(!visited[v])
                {
                    // Dest Reached
                    if(v == dest)
                        return true;

                    // mark Visited - add Src to Queue
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

        // No Path Exits
        return false;
    }
}