public class Solution {
    public static int streetTravel(int[][] grid, int[] src, int[] dest)
    {
        int r = grid.length, c = grid[0].length; 

        // Four Directions: up, right, down, left
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // No. of Street Traveled (Src -> Dest)
        int count = 0; 

        Deque<int[]> q = new ArrayDeque<>(); 

        // add Src and mark visited
        q.offer(new int[]{src[0], src[1]}); 
        grid[src[0]][src[1]] = 2; 

        // Batch wise BFS traversal
        while (!q.isEmpty()) 
        {
            int qLen = q.size(); 

            // Traverse over queue Length
            for (int i = 0; i < qLen; i++) 
            {
                // get cur Cell
                int[] cur = q.poll(); 

                // Check if Dest is reached
                if (cur[0] == dest[0] && cur[1] == dest[1]) 
                {
                    return count; 
                }

                // Explore all 4 directions
                for (int[] dist : directions) 
                {
                    int row = cur[0] + dist[0];
                    int col = cur[1] + dist[1];

                    // Keep moving until row, col is Valid and exists Path
                    while (row >= 0 && col >= 0 && row < r && col < c
                             && grid[row][col] == 1) 
                    {
                        // add next Batch to Queue
                        q.offer(new int[]{row, col}); 
                        grid[row][col] = 2;

                        // Continue in same direction
                        row += dist[0]; 
                        col += dist[1];
                    }
                }
            }

            // One Street Traveled in all Directions
            count++; 
        }

        // Can't reach Dest 
        return -1; 
    }
}
