class Solution {
    public void islandsAndTreasure(int[][] grid) 
    {
        int r = grid.length, c = grid[0].length;

        // Directions: up, down, left, right
        int[][] directions = {
            {-1, 0}, {1, 0},
            {0, -1}, {0, 1}
        };

        Deque<int[]> q = new ArrayDeque<>();

        // Add all treasure cells (value 0) to the queue
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                if (grid[i][j] == 0) 
                    q.offer(new int[]{i, j});
            }
        }

        // Start distance from treasure
        int nearTreasure = 1;  

        // Multi-source BFS from all treasure
        while (!q.isEmpty()) 
        {
            // Level-Level Queue traversal from Treasures
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) 
            {
                int[] cur = q.poll();

                // Check all four Directions
                for (int[] dist : directions) 
                {
                    int row = cur[0] + dist[0];
                    int col = cur[1] + dist[1];

                    // If in bounds and the cell is empty (unvisited)
                    if (row >= 0 && row < r && col >= 0 && col < c &&
                        grid[row][col] == Integer.MAX_VALUE) 
                    {
                        // Update distance and add to queue
                        grid[row][col] = nearTreasure;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            // Move to next distance level
            nearTreasure++; 
        }
    }
}
