/*
213. House Robber II
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:

Input: nums = [1,2,3]
Output: 3

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 1000



"House Robber II is different from House Robber I because 
the houses are arranged in a circle, so the first and last
houses are adjacent. I can't rob both of them. I handle 
this by breaking the problem into two linear House Robber
problems. In the first case, I exclude the last house and 
consider houses 0 to n-2. In the second case, I exclude
the first house and consider houses 1 to n-1. For each
linear range, I use the same take-or-skip recurrence from
House Robber I: max(nums[i] + f(i-2), f(i-1)). Finally,
I take the maximum of the two cases."

*/


class Solution {
    private int linearRob(int[] nums,int s,int e){
        if(s > e) return 0;
        int rob = nums[s] + linearRob(nums,s + 2,e);
        int skip = linearRob(nums,s+1,e);
        return Math.max(rob,skip);
    }
    private int solve(int[] nums,int n){
        if(n == 1) return nums[0];
        int case1 = linearRob(nums,0,n-2);
        int case2 = linearRob(nums,1,n-1);
        return Math.max(case1,case2);
    }
    public int rob(int[] nums) {
        return solve(nums,nums.length);
    }
}

class Solution {
    private int linearRob(int[] nums,int s,int e,int[] dp){
        if(s > e) return 0;
        if(dp[s] != -1) return dp[s];
        int rob = nums[s] + linearRob(nums,s + 2,e,dp);
        int skip = linearRob(nums,s+1,e,dp);
        dp[s] = Math.max(rob,skip);
        return dp[s];
    }
    private int solve(int[] nums,int n){
        if(n == 1) return nums[0];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1,-1);
        int case1 = linearRob(nums,0,n-2,dp1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,-1);
        int case2 = linearRob(nums,1,n-1,dp2);
        return Math.max(case1,case2);
    }
    public int rob(int[] nums) {
        
        return solve(nums,nums.length);
    }
}
