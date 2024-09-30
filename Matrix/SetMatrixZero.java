class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        // (0, 0) overLaps - rowZero
        boolean rowZero = false;

        // use first ROW, COL as set Matrix Zero
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                if(matrix[r][c] == 0)
                {
                    // set Col Zero
                    matrix[0][c] = 0;

                    // set Row Zero
                    if(r > 0)
                        matrix[r][0] = 0;
                    else
                        rowZero = true;
                }
            }
        }

        for(int r=1; r<row; r++)
        {
            for(int c=1; c<col; c++)
            {
                // for Non OverLap - Set Row, Col Zero
                if(matrix[0][c] == 0 || matrix[r][0] == 0)
                    matrix[r][c] = 0;
            }
        }

        // set First Col Zero
        if(matrix[0][0] == 0)
        {
            for(int r=0; r<row; r++)
                matrix[r][0] = 0;
        }

        // set First Row Zero
        if(rowZero)
        {
            for(int c=0; c<col; c++)
                matrix[0][c] = 0;
        }
    }
}