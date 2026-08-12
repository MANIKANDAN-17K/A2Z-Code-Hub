class Solution {
    private int lis(int[] nums,int idx,int[] dp){
        if(idx == 0) return 1;
        if(dp[idx] != -1) return dp[idx];
        int max = 1;
        for(int j = 0;j<idx;j++){
            if(nums[j] < nums[idx])
            max = Math.max(max,lis(nums,j,dp)+1);
        }
        dp[idx] = max;
        return max;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int res = 1;
        for(int i = 1;i<n;i++){
            res = Math.max(res,lis(nums,i,dp));
        }
        return res;
    }
}

/*
Given an integer array nums, return the length of the longest strictly increasing .

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/
