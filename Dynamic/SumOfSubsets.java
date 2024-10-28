class Solution {
	public boolean sumofSubsets(int[] nums, int target) 
	{
		int n = nums.length;
		
		// Dynamic Programming : 
		//	i - nums 	j - target
		boolean[][] dp = new boolean[n + 1][target + 1];
		
		// 0 - target can be achived by without taking any nums (true)
		for(int i = 0; i <= n; i++)
		{
			dp[i][0] = true;
		}
		
		// Fill Table
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= target; j++)
			{
				// sum less than curNum - fill from above
				if(j < nums[i-1])
				{
					dp[i][j] = dp[i-1][j];
				}
				/*
				 	1) Exclude curNum
				 	2) Include curNum and check remaining Sum
				 	3) Sum obtain by Exclude |OR| Include
				*/
				else
				{
					// if including curNum can achive
					// 		 remaining Sum without curNum
					dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
				}
			}
		}
		
		// Print SubSet of target Sum
		int i = n, j = target;
		while(i > 0 && j > 0)
		{
			// different : this coin included in Subset
			if(dp[i][j] != dp[i-1][j])
			{
				System.out.println(nums[i-1]);
				
				// remaining Sum
				j -= nums[i-1];
			}

            // Not Included in Subset
			i--;	
		}
		
		// NotFound - false : Found - True
		return dp[n][target];
	}
}
