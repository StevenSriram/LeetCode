/*
    1 - Live    0 - Dead

    1 - { < 2 and > 3 }  Dead next Gen
    1 - { = 2 or 3 }     Live next Gen
    0 - { = 3  }         Live next Gen
*/
class Solution {
    int r, c;
    /*
        Current | Next | State
            0   |   0  |    0
            1   |   0  |    1
            0   |   1  |    2
            1   |   1  |    3
    */

    public void gameOfLife(int[][] board) {
        r = board.length;
        c = board[0].length;

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                int neighbour = countNeighbours(board, i ,j);

                // 1 : Case
                if(board[i][j] == 1)
                {
                    // 1 - Living in Next gen
                    if(neighbour == 2 || neighbour == 3)
                    {
                        board[i][j] = 3;
                    }
                    // under\over Population Dead
                    /*  
                        else if(neighbour < 2 || neighbour > 3)
                            board[i][j] = 1
                    */
                }
                // 0 : Case
                else if(neighbour == 3)
                {
                    // 0 - Living in Next gen
                    board[i][j] = 2;
                }
                // Dead remains Dead
                /*
                    else
                        board[i][j] = 0
                */
            }
        }

        // Trace Back for Space : O(1)
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // State 1 - Dead
                if(board[i][j] == 1)
                    board[i][j] = 0;

                // State 2, 3 - Live
                else if(board[i][j] == 2 || board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    public int countNeighbours(int[][] board, int row, int col)
    {
        // count No. neighbours Alive
        int neiCount = 0;

        for(int i=-1; i<=1; i++)
        {
            for(int j=-1; j<=1; j++)
            {
                // skip current Cell
                if(i == 0 && j == 0) continue;

                int nx = row + i;
                int ny = col + j;
                
                // check Bounds and Alive
                if(nx >= 0 && nx < r && ny >= 0 && ny < c &&  
                        ( board[nx][ny] == 1 || board[nx][ny] == 3))
                {
                    neiCount++;
                }
            }
        }
        return neiCount;
    }
}