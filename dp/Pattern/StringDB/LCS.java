/*
1143. Longest Common Subsequence
Solved
Medium
Topics
premium lock iconCompanies
Hint

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

 

Constraints:

    1 <= text1.length, text2.length <= 1000
    text1 and text2 consist of only lowercase English characters.

*/

// brute force 

class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        return LCS(text1,text2,n1 - 1,n2 - 1);
    }
    private int LCS(String s1,String s2,int i,int j){
        if(i < 0 || j < 0) return 0;
        if(s1.charAt(i) == s2.charAt(j)) return 1 + LCS(s1,s2,i-1,j-1);
        return Math.max(LCS(s1,s2,i-1,j),LCS(s1,s2,i,j-1));
    }
}

// memoizaton 

class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        dp = new int[n1][n2];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return LCS(text1,text2,n1 - 1,n2 - 1);
    }
    private int LCS(String s1,String s2,int i,int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j] =  1 + LCS(s1,s2,i-1,j-1);
        else dp[i][j] = Math.max(LCS(s1,s2,i-1,j),LCS(s1,s2,i,j-1));
        return dp[i][j];
    }
}
