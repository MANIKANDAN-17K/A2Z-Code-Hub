class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for(int i =0 ;i<n;i++){
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int j = i;j<n;j++){
                mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int val : mp.values()){
                    max = Math.max(max,val);
                    min = Math.min(min,val);
                }
                sum += (max - min);
            }
        }
        return sum;
    }
}

/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

    For example, the beauty of "abaacc" is 3 - 1 = 2.

Given a string s, return the sum of beauty of all of its substrings.

 

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

Example 2:

Input: s = "aabcbaa"
Output: 17

  */
