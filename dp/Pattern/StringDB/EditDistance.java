72. Edit Distance

Given two strings word1 and word2,
return the minimum number of operations required 
to convert word1 to word2.

You have the following three operations 
permitted on a word:

    Insert a character
    Delete a character
    Replace a character

 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 

Constraints:

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.




class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        return edit(word1,word2,n1-1,n2-1);
    }
    private int edit(String s1,String s2,int i,int j){
        if(i == 0) return j + 1;
        if(j == 0) return i + 1;
        if(s1.charAt(i) == s2.charAt(j)) return edit(s1,s2,i-1,j-1);
        int insert = edit(s1,s2,i-1,j);
        int delete = edit(s1,s2,i,j-1);
        int replace = edit(s1,s2,i-1,j-1);
        return 1 + Math.min(insert,Math.min(delete,replace));
    }
}

class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        dp = new int[n1][n2];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return edit(word1,word2,n1-1,n2-1);
    }

    private int edit(String s1,String s2,int i,int j){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j] =  edit(s1,s2,i-1,j-1);
        else{
            int insert = edit(s1,s2,i,j-1);
            int delete = edit(s1,s2,i-1,j);
            int replace = edit(s1,s2,i-1,j-1);
            dp[i][j] =  1 + Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j];
    }
}
