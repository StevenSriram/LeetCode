class Solution {
    // Euclidean Distance : √ (x1 - x2)2 + (y1 - y2)2
    public int distance(int x, int y)
    {
        // Origin : (0, 0)

        // (x)2 + (y)2 - sqrt for roundUp function
        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) 
    {
        // PQ : Order based on Max Distance from Origin
        Queue<int []> maxHeap = new PriorityQueue<>((a, b) -> 
                distance(b[0], b[1]) - distance(a[0], a[1]));
        
        // take each Points
        for(int[] xy : points)
        {
            // add it to PQ
            maxHeap.offer(xy);
            
            // PQ size greater than K
            if(maxHeap.size() > k)
            {
                /* always Ensure atmost K */

                // remove Max distance
                maxHeap.poll();
            }
        }

        // result of K Closest Points
        List<int[]> res = new ArrayList<>();

        while(!maxHeap.isEmpty())
        {
            // add to Result
            res.add(maxHeap.poll());
        }

        // return as int[][]
        return res.toArray(new int[k][]);
    }
}