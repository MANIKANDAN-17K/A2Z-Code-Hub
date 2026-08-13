class Solution {
    int findProfit(int idx,int k,int buy,int[] prices,int[][][] dp){
        if(k <= 0 || idx >= prices.length) return 0;
        if(dp[idx][k][buy] != -1) return dp[idx][k][buy];
        int res = 0;
        if(buy == 1)
            res = Math.max(findProfit(idx+1,k,0,prices,dp) - prices[idx],findProfit(idx+1,k,1,prices,dp));
        else
            res = Math.max(findProfit(idx+1,k-1,1,prices,dp)+prices[idx],findProfit(idx+1,k,0,prices,dp));
        return dp[idx][k][buy] = res;
    }
    int maxProfit(int prices[], int k) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int[][] d : dp){
            for(int[] p : d){
                Arrays.fill(p,-1);
            }
        }
        return findProfit(0,k,1,prices,dp);
    }
}
/*
Given an array prices[], where prices[i] represents the price of a stock on the i-th day, and an integer k representing the maximum number of transactions allowed, find the maximum profit that can be earned by performing at most k transactions.

Note: A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.

Examples :

Input: prices[] = [10, 22, 5, 80], k = 2
Output: 87
Explaination:
1st transaction: Buy at 10 and sell at 22.
2nd transaction: Buy at 5 and sell at 80.
Total Profit will be 12 + 75 = 87.

Input: prices[] = [20, 25, 30, 40, 10, 20], k = 3
Output: 30
Explaination:
1st transaction: Buy at 20 and sell at 40. 
2nd transaction: Buy at 10 and sell at 20.
Total Profit will be 20 + 10 = 30.

Input: prices[] = [90, 80, 70, 60, 50], k = 1
Output: 0
Explaination: Selling price is decreasing continuously leading to loss. So seller cannot have any profit.
  */
