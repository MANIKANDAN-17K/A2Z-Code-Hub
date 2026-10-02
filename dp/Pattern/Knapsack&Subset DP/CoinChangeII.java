/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The final answer is guaranteed to fit into a signed 32-bit integer.


Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10]
Output: 1

Constraints:

    1 <= coins.length <= 300
    1 <= coins[i] <= 5000
    All the values of coins are unique.
    0 <= amount <= 5000

"At each coin, I have two choices: either take
the current coin or skip it. Since a coin can be
used unlimited times, when I take it I stay at 
the same index and reduce the remaining amount.
If I skip it, I move to the next coin. Since I'm
counting all valid combinations, I add the number
of ways from both choices. The state is (index, amount),
and I memoize it because the same state can be reached
multiple times."

dp(i, amount)
=
    dp(i, amount - coins[i])     // TAKE
    +
    dp(i + 1, amount)            // SKIP

 */


class Solution {
    public int change(int amount, int[] coins) {
        return solve(0,amount,coins);
    }
    private int solve(int idx,int tar,int[] A){
        if(tar == 0) return 1;
        if(idx == A.length) return 0;
        int take = 0;
        if(A[idx] <= tar){
            take += solve(idx,tar - A[idx],A;
        }
        take += solve(idx + 1,tar,A);
        return take;
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return solve(0,amount,coins,dp);
    }
    private int solve(int idx,int tar,int[] A,int[][] dp){
        if(tar == 0) return 1;
        if(idx == A.length) return 0;
        if(dp[idx][tar] != -1) return dp[idx][tar];
        int take = 0;
        if(A[idx] <= tar){
            take += solve(idx,tar - A[idx],A,dp);
        }
        take += solve(idx + 1,tar,A,dp);
        dp[idx][tar] = take;
        return take;
    }
}
