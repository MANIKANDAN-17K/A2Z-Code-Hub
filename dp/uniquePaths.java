class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
   
}
/*
Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 */
