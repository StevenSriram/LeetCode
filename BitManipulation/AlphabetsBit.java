public class Solution
{
    /* "abcdefghijklmnopqrstuvwxyz" */
	public boolean allAlphabets(String s) 
	{
        // BitMask - Map Char Pos to its Bit [26]
		int bitFlag = 0;
		
        // take Each Char
		for(char ch : str.toCharArray())
		{
            // compute its Pos [1 - 26]
		    int pos = ch - 'a';
		    
            // Mark Visited
		    bitFlag = bitFlag | (1 << pos);
            /*
                00000000000000000000000000000000

                char 'b' : 1 left Shift 2
                00000000000000000000000000000010

                Visited  :
                00000000000000000000000000000010
            */
		}
		
        // check if all 26 bits are set Visited
        /* 
           26 bits with 0 - 100000000000000000000000000000000 
           26 bits with 1 - 11111111111111111111111111111111

           bitFlag == 11111111111111111111111111111111 (matches)
        */
		return bitFlag == (1 << 26) - 1;
	}
}
