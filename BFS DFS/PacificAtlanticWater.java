class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int r = heights.length, c = heights[0].length;

        // BFS Queues from Pacific and Atlantic oceans
        Deque<int[]> pQ = new ArrayDeque<>();
        Deque<int[]> aQ = new ArrayDeque<>();

        // Visited Cells in Pacific and Atlantic oceans
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for(int i = 0; i < r; i++) 
        {
            // Pacific Ocean : (Left edge)
            pQ.offer(new int[]{i, 0});
            pacific[i][0] = true;

            // Atlantic Ocean : (Right edge)
            aQ.offer(new int[]{i, c - 1}); 
            atlantic[i][c - 1] = true;
        }

        for(int j = 0; j < c; j++) 
        {
            // Pacific Ocean : (Top edge)
            pQ.offer(new int[]{0, j});
            pacific[0][j] = true;

            // Atlantic Ocean : (Bottom edge)
            aQ.offer(new int[]{r - 1, j});
            atlantic[r - 1][j] = true;
        }

        // Perform BFS for both oceans to mark reachable cells
        bfs(heights, pQ, pacific);
        bfs(heights, aQ, atlantic);

        // Cells that can reach both Oceans
        List<List<Integer>> waterFlow = new ArrayList<>();

        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                if (pacific[i][j] && atlantic[i][j]) 
                    waterFlow.add(Arrays.asList(i, j));
            }
        }

        return waterFlow;
    }

    // Breadth-First Search to mark reachable cells
    public void bfs(int[][] heights, Deque<int[]> q, boolean[][] visited)
    {
        int r = heights.length, c = heights[0].length;

        // Directions: up, right, down, left
        int[][] directions = new int[][]{ {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        while (!q.isEmpty())
        {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];

            for (int[] dist : directions)
            {
                int row = i + dist[0];
                int col = j + dist[1];

                // Check bounds, if not visited, and if water can flow from current to neighbor
                if (row >= 0 && row < r && col >= 0 && col < c
                    && !visited[row][col] && heights[row][col] >= heights[i][j])
                {
                    q.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
    }
}
