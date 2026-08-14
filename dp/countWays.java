/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.

Count the number of ways, the person can reach the top (order does matter). 

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair. 

Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: [1, 1, 1, 1], [1, 1, 2], [2, 1, 1], [1, 2, 1] and [2, 2].

*/

class Solution {
    private int count(int n,int[] dp){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        int one = count(n-1,dp);
        int two = count(n-2,dp);
        return dp[n] = one + two;
    }
    public int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp);
    }
}
