/*
312. Burst Balloons

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a 
number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. 
If i - 1 or i + 1 goes out of bounds of the array, then treat it
as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:

Input: nums = [1,5]
Output: 10

 

Constraints:

    n == nums.length
    1 <= n <= 300
    0 <= nums[i] <= 100
 */
class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0;i<n;i++)
            arr[i+1] = nums[i];
        dp = new int[n+2][n+2];
        return solver(arr,1,n);
    }
    private int solver(int[] arr,int l,int r){
        if(l > r) return 0;
        if(dp[l][r] != 0) return dp[l][r];
        int max = 0;
        for(int k= l;k<=r;k++){
            int coin = arr[l-1] * arr[k] * arr[r+1] + solver(arr,l,k-1) + solver(arr,k + 1,r);
            max = Math.max(max,coin);
        }
        return dp[l][r] = max;
    }
}
