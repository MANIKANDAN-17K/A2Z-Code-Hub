class Solution {
    private int findMax(int[] arr,int n,int[] dp){
        if( n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] =  Math.max(arr[n] + findMax(arr,n-2,dp),findMax(arr,n-1,dp));
    }
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return findMax(arr,n - 1,dp);
    }
}
