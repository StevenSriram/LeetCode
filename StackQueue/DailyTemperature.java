class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n = temperatures.length;

        // Warmer Temperature from cur Day
        int[] warmerTemp = new int[n];

        // store the indices of Temps
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) 
        {
            
            // If cur Temp is higher than top of stack
            while (!stack.isEmpty() &&
                 temperatures[stack.peek()] < temperatures[i]) 
            {
                // index of colder temp
                int idx = stack.pop();
                
                // Calculate no. of days until a Warmer Temperature
                warmerTemp[idx] = i - idx;  /* Warmer - Colder */
            }

            // Push cur index to stack
            stack.push(i);
        }

        return warmerTemp;
    }
}
