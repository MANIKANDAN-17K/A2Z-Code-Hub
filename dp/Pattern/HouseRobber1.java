/*
198. House Robber


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 400

*/

/*
"For every house,
  I have two choices: either rob the current house or skip it.
  If I rob the current house, 
  I cannot rob the previous house,
  so I move to i-2. If I skip the current house, 
  I move to i-1. Therefore, my recurrence is max(nums[i] + solve(i-2), solve(i-1)).
  Since the recursive solution has overlapping subproblems, 
  I use memoization to store the result for each index."
*/
//brute force
class Solution {
    private int maxSum(int[] nums,int n){
        if(n < 0) return 0;
        if(n ==  0) return nums[n];
        int rop = nums[n] + maxSum(nums,n-2);
        int skip = maxSum(nums,n - 1);
        return Math.max(rop,skip);
    }
    public int rob(int[] nums) {
        return maxSum(nums,nums.length - 1);
        
    }
}

// memo
class Solution {
    private int maxSum(int[] nums,int n,int[] dp){
        if(n < 0) return 0;
        if(n ==  0) return nums[n];
        if(dp[n] != -1) return dp[n];
        int rop = nums[n] + maxSum(nums,n-2,dp);
        int skip = maxSum(nums,n - 1,dp);
        dp[n] = Math.max(rop,skip);
        return dp[n];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return maxSum(nums,nums.length - 1,dp);
        
    }
}
