class Solution {
    /*
        Chef wants to maximize his satisfaction when selecting M dishes. Each dish has:

            A size (representing portion size)
            A taste (representing taste satisfaction per unit size)

        Total Satisfaction = (Sum of sizes of selected dishes) × (Minimum taste among selected dishes)
    */
    public int chefMaxSatisfaction(int[][] dishes, int k) 
    { 
        // maximum satisfaction value of K Dishes
        int maxSatisfaction = 0; 

        // Sort dishes by Taste descending, then by Size descending
        Arrays.sort(dishes, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1];
            
            return b[0] - a[0]; 
        });
        
        // Heap to store K dish sizes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 

        // total size of selected dishes
        int totalSize = 0; 
        
        for (int[] dish : dishes) 
        {
            // add cur Dish size to Heap, Total
            minHeap.offer(dish[0]); 
            totalSize += dish[0]; 
            
            // If more than k dishes selected
            if (minHeap.size() > k) 
            {
                // remove the smallest dish
                totalSize -= minHeap.poll(); 
            }
            
            // Calculate satisfaction and update maximum if needed
            maxSatisfaction = Math.max(maxSatisfaction, totalSize * dish[1]);
        }
        
        return maxSatisfaction;
    }
}