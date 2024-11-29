class Solution {
    // Randomized Median Algorithm : Ensures O(N)

    public static int kthSmallest(int[] arr, int k)
    {
        // Array to ArrayList " (primitive -> reference).boxed() "
        List<Integer> S = Arrays.stream(arr).boxed().toList();

        // select(S, kth Smallest)
        return select(S, k);
    }

    public static int select(List<Integer> S, int k)
    {
        // Random index between Range
        Random rand = new Random();
        int randIdx = rand.nextInt(S.size());

        // Store Value Lesser than Pivot
        List<Integer> Sminus = new ArrayList<>();

        // Store Value Greater than Pivot
        List<Integer> Splus = new ArrayList<>();

        for(int i = 0; i < S.size(); i++)
        {
            if(i == randIdx)
                continue;

            // Less : add to S-
            if(S.get(i) < S.get(randIdx))
            {
                Sminus.add(S.get(i));
            }
            // Great : add to S+
            else
            {
                Splus.add(S.get(i));
            }
        }

        // size of S- exactly equals to K - 1
        if(Sminus.size() == k - 1)
        {
            // cur Random Idx - Kth Smallest
            return S.get(randIdx);
        }

        // size greater than equals to K
        else if(Sminus.size() >= k)
        {
            // Kth Smallest present of S-
            return select(Sminus, k);
        }

        // size lesser than K
        else
        {
            // Kth Smallest present in S+
            /*
                but to find Index to Select,

                K - (remove the size of S-) - (remove Pivot)
            */
            return select(Splus, k - Sminus.size() - 1);
        }
    }
}