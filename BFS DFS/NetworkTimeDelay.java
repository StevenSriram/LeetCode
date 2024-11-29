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

    public int networkDelayTime(int[][] times, int n, int k)
    {
        adjList = new List[n];

        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        // take each Edges
        for(int[] edg : times)
        {
            // 0 : Based Indexing
            int u = edg[0] - 1;
            int v = edg[1] - 1;
            int w = edg[2];

            // add directed Edge
            adjList[u].add(new Edge(u, v, w));
        }

        // Shortest Time to send data to all Nodes
        return dijkstraAlgo(n, k - 1);
    }

    public int dijkstraAlgo(int V, int start)
    {
        // Distance Array - Shortest Path to reach Node
        int[] dist = new int[V];

        // fill with Infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // mark shortest Distance to Start as '0'
        dist[start] = 0;

        // visited Array
        boolean[] visited = new boolean[V];

        // Min-Heap to find min weight
        Queue<Edge> pq = new PriorityQueue<>( (u, v) -> u.weight - v.weight );

        // add Dummy node to Start
        pq.offer(new Edge(-1, start, 0));

        // while PQ - not Empty
        while(! pq.isEmpty())
        {
            Edge cur = pq.poll();

            // take Cur Node
            int u = cur.dest;

            // take each Neighbours
            for(Edge neig : adjList[u])
            {
                // take Nxt Node
                int v = neig.dest;
                int wt = neig.weight;

                /*  Relaxation  */
                if(dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;

                    // add min to PQ
                    pq.offer(new Edge(u, v, dist[v]));
                }
            }
        }

        // Minimum time to recieve Signal
        int minTimeSignal = Integer.MIN_VALUE;

        for(int i = 0; i < V; i++)
        {
            // any Node is Un-reached
            if(dist[i] == Integer.MAX_VALUE)
                return -1;

            // update Time Delay
            minTimeSignal = Math.max(minTimeSignal, dist[i]);
        }

        return minTimeSignal;
    }
}