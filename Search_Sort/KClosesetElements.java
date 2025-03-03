class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        /*
            we are Not' finding X and then K window
            we found K window itself
        */

        // L : 0   R : len - k (Valid Windows)
        int l = 0, r = arr.length - k;

        // L and R are not Cross Over
        while(l < r)
        {
            // Mid : Start of Window - K
            int mid = (l + r) / 2;

            /*
                check curWindow and nextWindow
                    whick is closest to X

                 X is greater       mid+k is greater
                (X - arr[mid]) or (arr[mid + k] - X)
            */

            // nextWindow is closeset to X : move to next (L = Mid + 1)
            if (x - arr[mid] > arr[mid + k] - x)
                l = mid + 1;
            
            // curWindow is closest to X : eliminate all Right side
                // but not curWindow (R = Mid)
            else
                r = mid;
        }
        
        // return Window of [L, L + K] as List
        return Arrays
                .stream(Arrays.copyOfRange(arr, l , l + k))
                .boxed() // int -> Integer
                .collect(Collectors.toList());
    }
}