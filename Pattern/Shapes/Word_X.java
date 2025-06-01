public class Solution {
    /*
        C   i
         o e 
          d  
         o e 
        C   i
    */
    
    public void wordPattern(String s)
    {
        int N = s.length();
        
        // Index to iterate Word
        int idx = 0;

        // loop I : 0 - N
        for(int i=0; i<N; i++)
        {
            // loop J : 0 - N
            for(int j=0; j<N; j++)
            {
                // -Ve Diagnal -> char(Idx)
                if(i == j)
                    System.out.print(s.charAt(idx));
                
                // +Ve Diagonal -> char(N - 1 - Idx)
                else if(i + j == N-1)
                    System.out.print(s.charAt(N - 1 - idx));
                
                // print Space
                else
                    System.out.print(" ");
            }

            // NewLine and move Index
            System.out.println();
            idx++;
        }
    }
}