class Solution {
    private int maxPoint(int n,int[] price,int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int ans = 0;
        for(int j = 1;j<=n;j++){
            ans = Math.max(ans,price[j - 1] + maxPoint(n - j,price,dp));
        }
        return dp[n] = ans;
    }
    public int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return maxPoint(n,price,dp);
        
    }
}
/* 
class Solution {
    private int maxPoint(int n,int[] price){
        if(n == 0) return 0;
        int ans = 0;
        for(int j = 1;j<=n;j++){
            ans = Math.max(ans,price[j - 1] + maxPoint(n - j,price));
        }
        return ans;
    }
    public int cutRod(int[] price) {
        int n = price.length;
        return maxPoint(n,price);
        
    }
}
Rod Cutting
Solved
Difficulty: MediumAccuracy: 60.66%Submissions: 227K+Points: 4Average Time: 20m

Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index). Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: The value of n is equal to the size of price array.

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.

Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.

Input: price[] = [3]
Output: 3
Explanation: There is only 1 way to pick a piece of length 1.

Constraints:
1 ≤ price.size() ≤ 103
1 ≤ price[i] ≤ 106
*/
