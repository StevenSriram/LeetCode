class Solution {
    // all combination N-Queen Placement
    List<List<String>> res;

    // N x N chess Board
    char[][] board;
    
    // track Queen Placement in different Columns
    Set<Integer> cols;

    // track Queen Placement in different Diagonals
    Set<Integer> negDiagonal;
    /* -Ve Diagonal 
            from TopLeft to BottomRight (row +, col +)

        Formula : (Row - Col) same Along -Ve diagonal
    */
    Set<Integer> posDiagonal;
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

        // for Each Colums
        for(int c = 0; c < n; c++)
        {
            /* check Queen already placed in Same Column, Diagonals */
            if(cols.contains(c) || negDiagonal.contains(r - c) ||
                    posDiagonal.contains(r + c))
                continue;

            // mark Column, Diagonals - Place Queen
            cols.add(c);
            negDiagonal.add(r - c);
            posDiagonal.add(r + c);
            board[r][c] = 'Q';

            // Move to next Row to place next Queen
            backTrack(r + 1, n);

            // BackTracing : remove marked Column, Diagonals - Placed Queen
            cols.remove(c);
            negDiagonal.remove(r - c);
            posDiagonal.remove(r + c);
            board[r][c] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) 
    {
        res = new ArrayList<>();

        // fill table with '.'
        board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');

        cols = new HashSet<>();
        negDiagonal = new HashSet<>();
        posDiagonal = new HashSet<>();

        // PlaceQueen ( row, No. Queens)
        backTrack(0, n);

        return res;
    }
}