/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 

Constraints:

    1 <= n <= 45


*/


/*
"The last move to step n can either 
  be a 1-step move from n-1 or a 2-step move 
  from n-2. Therefore, ways(n) = ways(n-1) + ways(n-2).
  The base cases are ways(1)=1 and ways(2)=2. 
  In brute force, I recursively calculate these values, 
  but overlapping subproblems cause exponential time, O(2^n). 
  To optimize, I use memoization and store each computed 
  result in an array. This reduces the time complexity to O(n)."

*/
// recusions
class Solution {
    private int rec(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return rec(n-1) + rec(n - 2);
    }
    public int climbStairs(int n) {
        return rec(n);
    }
}


// memo
class Solution {
    private int rec(int n,int[] dp){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != 0) return dp[n];
        dp[n] =  rec(n-1,dp) + rec(n - 2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return rec(n,dp);
    }
}
