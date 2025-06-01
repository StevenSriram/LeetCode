class Solution {
    public int minimumTime(int[][] grid) 
    {
        int n = grid.length, m = grid[0].length;    

        // can't Move : time greater than 1
        if(grid[1][0] > 1 && grid[0][1] > 1)
            return -1;

        // four Directions
        int[][] directions = new int[][]{ {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        // Priority Queue based on min Time
        Queue<int[]> pq = new PriorityQueue<>((i, j) -> i[2] - j[2]);

        // Visited matrix
        boolean[][] visited = new boolean[n][m];

        // add Cell with 0 time and mark Visited
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        // pq - Not Empty
        while(! pq.isEmpty())
        {
            // take grid with minTime
            int[] cur = pq.poll();

            int i = cur[0], j = cur[1], time = cur[2];

            // if reached End of Cell - return MinTime
            if(i == n - 1 && j == m - 1)
                return time;

            // move to four Directions
            for(int[] dist : directions)
            {
                int row = i + dist[0];
                int col =  j + dist[1];

                // check Inbounds and not Visited
                if(row >=0 && row < n && col >= 0 && col < m &&
                    ! visited[row][col])
                {
                    int newTime = 0;

                    // time of nextCell greater than curTime
                    if(grid[row][col] > time)
                    {
                        // calculate Time Difference
                        int diff = grid[row][col] - time;

                        /*
                            Do Filkering until Time reached

                            Even : 1->  2<-  3->  4<- 5| (nextTime + 1)
                            Odd : 1->  2<-  3| (nextTime)
                        */
                        newTime = diff % 2 == 0 ? 
                                    grid[row][col] + 1 : grid[row][col];
                    }

                    // curTime greater than or equal to nextTime
                    else
                    {
                        // move curTime + 1
                        newTime = time + 1;
                    }

                    // add newTime to PQ and mark Visited
                    pq.offer(new int[]{row, col, newTime});
                    visited[row][col] = true;
                }
            }
        }

        // can't Reach End Cell
        return -1;
    }
}
