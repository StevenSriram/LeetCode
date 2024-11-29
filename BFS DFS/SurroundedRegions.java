class Solution {
    /*
        REVERSE ENGINEERING : thinking in reverse way

        1. Capture all Surrounded Regions

        2. Capture every Regions except Un-Surronded Regions
    */
    public void solve(char[][] board)
    {
        int r = board.length;
        int c = board[0].length;

        /* Capture Un-Surrounded regions - BFS on four Directions */
                /*    ( 'O' -> 'T' )     */

        Queue<int []> q = new ArrayDeque<>();

        // four Directions - BFS
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        // loop through board
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                // border Row, Col
                if( (i == 0 || i == r - 1 ||
                    j == 0 || j == c - 1) && board[i][j] == 'O' )
                {
                    // capture Un-Surrounded
                    q.offer(new int[]{i, j});
                    board[i][j] = 'T';

                    while(! q.isEmpty())
                    {
                        int[] cur = q.poll();

                        // for each directions
                        for(int[] dist : directions)
                        {
                            int row = cur[0] + dist[0];
                            int col = cur[1] + dist[1];

                            // capture Neighbour - UnSurrounded
                            if(row >= 0 && row < r && col >= 0 &&
                                    col < c &&  board[row][col] == 'O')
                            {
                                q.offer(new int[]{row, col});
                                board[row][col] = 'T';
                            }
                        }
                    }
                }
            }
        }


        /* capture all Surrounded regions */
            /*    ( '0' -> 'X' )    */

        // loop through board
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                // capture Surrounded
                if(board[i][j] == 'O')

                    board[i][j] = 'X';
            }
        }


        /* release Un-Surrounded regions */
            /*    ( 'T' -> '0' )     */

        // loop through board
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                // Release Un-surrounded
                if(board[i][j] == 'T')

                    board[i][j] = 'O';
            }
        }
    }
}