public class SecondLargestElement {
	public int secondLargest(int[] nums) 
	{
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		
		for(int num : nums)
		{
            // Number greater than Max
			if(num > max)
			{
                // ? secMax = Prevmax
				secMax = max;

                // ? update Max
				max = num;
			}
			
            // Number Greater than SecMax and between Max
			else if(num > secMax && num < max)
			{
                // ? update SecMax
				secMax = num;
			}
		}

        // Second Max - Not Found
        if(secMax == Integer.MIN_VALUE)
            return -1;

        // Second Largest Element
        return secMax;
	}
}
