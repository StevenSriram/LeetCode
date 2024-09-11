class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length, c = mat[0].length;

        // Diagonal Traversal List
        List<Integer> res = new ArrayList<>();

        // Start with Diagonally Upward
        boolean up = true;

        // Traversal begins with (0, 0)
        int row = 0, col = 0;
        while(row < r && col < c)
        {
            // Upward Traversal
            if(up)
            {
                // reach Column End
                while(row > 0 && col < c-1)
                {
                    res.add(mat[row][col]);
                    // -ve Row and +ve Col
                    row--;
                    col++;
                }
                // diagonal End
                res.add(mat[row][col]);

                if(col == c-1)
                // move to next row
                    row++;
                else
                // single move to next col
                    col++;
            }
            // Downward Traversal
            else
            {
                // reach Row End
                while(col > 0 && row < r-1)
                {
                    res.add(mat[row][col]);
                    // +ve Row and -ve Col
                    row++;
                    col--;
                }
                // diagonal End
                res.add(mat[row][col]);

                if(row == r-1)
                // move to next col
                    col++;
                else
                // single move to next row
                    row++;
            }
            // switch Up and Down
            up = !up;
        }
        // res Stream to Array
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}