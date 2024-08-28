class Solution {
    int smoothCell(int[][] img, int r, int c)
    {
        int sum = 0, count = 0;

        // check its Surrounding 9 cells
        for(int i=-1; i<=1; i++)
        {
            for(int j=-1; j<=1; j++)
            {
                int rI = r + i;
                int cI = c + j;

                // doesn't exceeds bound
                if(rI >= 0 && rI < img.length && cI >= 0 && cI < img[0].length)
                {
                    sum += img[rI][cI];
                    count++;
                }
            }
        }
        // return average 
        return sum / count;
    }

    public int[][] imageSmoother(int[][] img) {
        int r = img.length;
        int c = img[0].length;

        int[][] res = new int[r][c];

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // smooth each cell
                res[i][j] = smoothCell(img, i, j);
            }
        }
        return res;
    }
}