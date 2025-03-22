class Solution {
    // all combination N-Queen Placement
    List<List<String>> res;

    // N x N chess Board
    char[][] board;
    
    // track Queen Placement in different Columns
    int colFlag;

    // track Queen Placement in different Diagonals
    int negDiagFlag;
    /* -Ve Diagonal 
            from TopLeft to BottomRight (row +, col +)

        Formula : (Row - Col) same Along -Ve diagonal

        ** (Row - Col) can have negative value so add N - 1 **
        Formula : (Row - Col) + N - 1
    */
    int posDiagFlag;
     /* +Ve Diagonal 
            from BottomLeft to TopRight (row -, col +)

        Formula : (Row + Col) same Along +Ve diagonal
    */

    public void backTrack(int r, int n)
    {
        // Row reached End: placed N-Queen
        if(r == n)
        {
            // add copy of Board to Res as String
            List<String> copy = new ArrayList<>();
            for(char[] row : board)
            {
                copy.add(String.valueOf(row));
            }
            res.add(copy);
        }

        // for Each Columns
        for(int c = 0; c < n; c++)
        {
            /* check Queen already placed in Same Column, Diagonals */
            if(
                (colFlag & (1 << c)) != 0 || 
                (negDiagFlag & (1 << (r - c + n - 1))) != 0 ||
                (posDiagFlag & (1 << (r + c))) != 0
              )
                continue;

            // mark Column, Diagonals - Place Queen
            board[r][c] = 'Q';

            colFlag |= (1 << c);
            negDiagFlag |= (1 << (r - c + n - 1));
            posDiagFlag |= (1 << (r + c));

            // Move to next Row to place next Queen
            backTrack(r + 1, n);

            // BackTracing : remove marked Column, Diagonals - Placed Queen
            board[r][c] = '.';

            colFlag ^= (1 << c);
            negDiagFlag ^= (1 << (r - c + n - 1));
            posDiagFlag ^= (1 << (r + c));
        }
    }

    public List<List<String>> solveNQueens(int n) 
    {
        res = new ArrayList<>();

        // fill table with '.'
        board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');

        // PlaceQueen ( row, No. Queens)
        backTrack(0, n);

        return res;
    }
}
