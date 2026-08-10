class Solution {
    private int maxPoint(int[][] mat,int i,int prev,int[][] dp){
        int n = mat.length;
        
        if( i >= n) return 0;
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
        int max = Integer.MIN_VALUE;
        for(int j = 0;j<3;j++){
            if(j != prev) {
                max = Math.max(max,mat[i][j] + maxPoint(mat,i + 1,j,dp));
            }
        }
        if(prev != -1) dp[i][prev] = max;
        return max;
    }
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return maxPoint(mat,0,-1,dp);
        
    }
}
