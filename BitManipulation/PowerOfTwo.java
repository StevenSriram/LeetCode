class Solution {
    public boolean isPowerOfTwo(int n) {
        // -Ve not Power of 2
        if(n <= 0)
            return false;

        return ( (n & (n-1)) == 0 );
        /*
            Power of 2 has property that is ,
                Number (AND) Number-1 = 0
            
            16  - 10000
            15  - 01111

            0   - 00000
        */
    }
}