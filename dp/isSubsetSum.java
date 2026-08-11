class Solution {
    static private boolean maxSum(int[] arr,int n,int sum,int[][] memo){
        if(sum == 0) return true;
        if(n == 0) return false;
        if(memo[n][sum] != -1)  return memo[n][sum] == 1;
        if(arr[n - 1] > sum)
            memo[n][sum] = maxSum(arr,n-1,sum,memo) ? 1 : 0;
        else
            memo[n][sum] = maxSum(arr,n-1,sum,memo) || maxSum(arr,n-1,sum - arr[n-1],memo) ? 1 : 0;
        return memo[n][sum] == 1;
    }
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        int[][] memo = new int[n+1][sum+1];
        for(int[] dp : memo){
            Arrays.fill(dp,-1);
        }
        return maxSum(arr,n,sum,memo);
    }
}
/*
Subset Sum Problem
Solved
Difficulty: MediumAccuracy: 32.0%Submissions: 488K+Points: 4

Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.

Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
  */
