/*
91. Decode Ways

You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

    "AAJF" with the grouping (1, 1, 10, 6)
    "KJF" with the grouping (11, 10, 6)
    The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).

Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"

Output: 2

Explanation:

"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"

Output: 3

Explanation:

"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:

Input: s = "06"

Output: 0

Explanation:

"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.

 

Constraints:

    1 <= s.length <= 100
    s contains only digits and may contain leading zero(s).

"I look at the string from left to right.
At every index, I have at most two choices:
decode one digit or decode two digits.
A single digit is valid if it is between 1 and 9, 
and two digits are valid if they form a number
between 10 and 26. After making either choice, 
I have the same decoding problem starting at a
later index, so recursion is natural. If I reach 
the end, I return 1 because I found one valid
decoding. If I encounter 0, I return 0 because
it cannot be decoded alone. Finally, because 
the same indices are reached multiple times,
I use memoization."

*/




class Solution {
    private int solve(String s,int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        int oneDigit = solve(s,i+1);
        int twoDigit = 0;
        if(i+1 < s.length()){
            int nums = Integer.parseInt(s.substring(i,i+2));
            if(nums > 9 && nums < 27) twoDigit = solve(s,i+2);
        }
        return oneDigit + twoDigit;
    }
    public int numDecodings(String s) {
        return solve(s,0);
        
    }
}

class Solution {
    private int solve(String s,int i,int dp[]){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int oneDigit = solve(s,i+1,dp);
        int twoDigit = 0;
        if(i+1 < s.length()){
            int nums = Integer.parseInt(s.substring(i,i+2));
            if(nums > 9 && nums < 27) twoDigit = solve(s,i+2,dp);
        }
        dp[i] = oneDigit + twoDigit;
        return dp[i];
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0,dp);
        
    }
}
