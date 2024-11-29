class Solution {

    // Edge of Directed Weighted Graph
    public static class Edge
    {
        int src;
        int dest;
        int weight;

        /*  src  -- weight -- > dest  */
        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Graph - Adjacency List
    List<Edge>[] adjList;

    public int minCostConnectPoints(int[][] points)
    {
        // No. of vertices
        int n = points.length;

        adjList = new List[n];

        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        // for each points
        for(int i = 0; i < n; i++)
        {
            int x1 = points[i][0];
            int y1 = points[i][1];

            // graph is Complete Graph - Every vertex
            for(int j = i + 1; j < n; j++)
            {
                int x2 = points[j][0];
                int y2 = points[j][1];

                // Weight of Edge = |x1 - x2| + |y1 - y2|
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                // add Undirected Edges
                adjList[i].add(new Edge(i, j, dist));
                adjList[j].add(new Edge(j, i, dist));
            }
        }

        // Minimum cost to connect All points
        return primsAlgo(n, 0);
    }

    public int primsAlgo(int V, int start)
    {
        // Visited Array
        boolean[] visited = new boolean[V];

        // key to track Min at each Point
        int[] key = new int[V];

        // fill with Infinity
        Arrays.fill(key, Integer.MAX_VALUE);

        // mark minCost of start as '0'
        key[start] = 0;

        // Min-Heap to find min cost
        Queue<Edge> pq = new PriorityQueue<>( (u, v) -> u.weight - v.weight );

        // add Dummy node to Start
        pq.offer(new Edge(-1, start, 0));

        int minCost = 0;

        // while PQ - not Empty
        while(! pq.isEmpty())
        {
            Edge cur = pq.poll();

            // take Cur Node
            int u = cur.dest;

            // already Visited - continue
            if(visited[u])
                continue;

            // mark Visited, add weight to min Cost
            visited[u] = true;
            minCost += cur.weight;

            // take each Neighbours
            for(Edge neig : adjList[u])
            {
                // take Nxt Node
                int v = neig.dest;
                int wt = neig.weight;

                // not Visited, weight less than Key
                if(! visited[v] && wt < key[v])
                {
                    // update Key
                    key[v] = wt;

                    // add min to PQ
                    pq.offer(new Edge(u, v, key[v]));
                }
            }
        }

        // Minimu Cost to Connect All Points
        return minCost;
    }
}