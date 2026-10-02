/*
516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's 
length in s.

A subsequence is a sequence that can be derived from another
sequence by deleting some or no elements without changing the
order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

 

Constraints:

    1 <= s.length <= 1000
    s consists only of lowercase English letters.

 */


class Solution {  
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return LPS(s,0,n - 1);
    }
    private int LPS(String s,int i,int j){
        if(i > j) return 0;
        if(i == j) return 1;
        if(s.charAt(i) == s.charAt(j)) return 2 + LPS(s,i +1 , j - 1);
        return Math.max(LPS(s,i + 1,j),LPS(s,i,j - 1));
    }
}


class Solution {  
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return LPS(s,0,n - 1);
    }
    private int LPS(String s,int i,int j){
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1 ) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) dp[i][j] =  2 + LPS(s,i +1 , j - 1);
        else dp[i][j] =  Math.max(LPS(s,i + 1,j),LPS(s,i,j - 1));
        return dp[i][j];
    }
}
