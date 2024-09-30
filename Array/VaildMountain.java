class Solution {
    public boolean validMountainArray(int[] arr) {
        // less than 3 Not Mountain
        if(arr.length < 3)
            return false;

        int i=0;
        // check for Increasing Cliff
        while(i < arr.length-1 && arr[i] < arr[i+1])
        {
            i++;
        }
        /* i - Peak value */

        // check for No Cliff and Full Cliff
        if(i == 0 || i == arr.length-1)
            return false;

        // check for Decreasing Cliff
        while(i < arr.length-1 && arr[i] > arr[i+1])
        {
            i++;
        }

        /* 
            True : Valid Mountain
            False : More than One Mountain
        */
        return i == arr.length-1;
    }
}