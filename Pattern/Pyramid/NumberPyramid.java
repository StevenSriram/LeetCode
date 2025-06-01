public class Solution {
    /*
        1
        6 2
        10 7 3       
        13 11 8 4    
        15 14 12 9 5 

        for each Row, the start of Row is Incremented by (N - i + 1)

            1
            6 (5 - 1 + 1) => +5
            10 (5 - 2 + 1) => +4
            13 (5 - 3 + 1) => +3
            15 (5 - 4 + 1) => +2

        compute each rowStart = 1, at end rowStart = (N - i + 1)


        for each Col , Num = rowStart then Step start from (N - i + 1) : Increment of nextRow

        Num = 10    Step = (5 - 3 + 1 )=> 3

            nextNum = Num - step    
            Num = 7 (10 - 3)

        on each= iteration Step gets Incremented by 1 (step++)

            nextNum = 3 (7 - 4)
        
    */
   
    public void diagonalNumberPyramid(int n) {
        // row Starts from 1
        int rowStart = 1;

        // row : 1 to N
        for(int i=1; i<=n; i++) {
            // num to print
            int num = rowStart;

            // Step on Col (nextRow Inc = nextCol Dec)
            int step = n - i + 1;

            // col : 1 to I
            for(int j=1; j<=i; j++) {
                System.out.printf("%d ", num);

                // decrease step for nextNum
                num -= step;
                step++;
            }

            // Inc of each Row
            rowStart += (n - i + 1);
            System.out.println();
        }
    }
}