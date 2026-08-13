class Solution {
    private int LIS(int low,int high,String s,int[][] dp){
        if(low > high) return 0;
        if(low == high) return 1;
        if(dp[low][high] != -1) return dp[low][high];
        if(s.charAt(low) == s.charAt(high)){
            return dp[low][high] = LIS(low+1,high-1,s,dp) + 2;
        }else{
            return dp[low][high] = Math.max(LIS(low,high-1,s,dp),LIS(low+1,high,s,dp));
        }
        
    }
    public int longestPalinSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return LIS(0,n-1,s,dp);
    }
}
/*
Given a string s, return the length of the longest palindromic subsequence.
A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.

Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.

Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.
  */
