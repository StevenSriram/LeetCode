public class Solution {
	public void numberGreater_Prev(int[] nums) 
	{
		// Maximum of Prev until Cur Number
		int max = Integer.MIN_VALUE;
		
		// for each Number
		for(int num : nums)
		{
			// Num greater than curMax
			if(num > max)
			{
				// update Current Maximum
				max = num;
				System.out.print(max + " ");
			}
		}
	}
}
