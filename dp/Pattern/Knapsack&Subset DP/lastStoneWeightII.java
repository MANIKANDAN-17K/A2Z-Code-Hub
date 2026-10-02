
/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.

Example 2:

Input: stones = [31,26,33,21,40]
Output: 5

Constraints:

    1 <= stones.length <= 30
    1 <= stones[i] <= 100
*/

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int tot = 0;
        for(int s : stones){
            tot += s;
        }
        return solve(0,0,stones,tot);
    }
    private int solve(int idx,int sum,int[] stones,int tot){
        if(idx == stones.length){
            int otherSum = tot - sum;
            return Math.abs(otherSum - sum);
        }
        int take = solve (idx + 1, sum + stones[idx],stones,tot);
        int skip = solve (idx + 1, sum, stones, tot);
        return Math.min(take,skip);
    }
}

class Solution {
    int dp[][];
    public int lastStoneWeightII(int[] stones) {
        int tot = 0;
        for(int s : stones){
            tot += s;
        }
        dp = new int[stones.length][tot + 1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return solve(0,0,stones,tot);
    }
    private int solve(int idx,int sum,int[] stones,int tot){
        if(idx == stones.length){
            int otherSum = tot - sum;
            return Math.abs(otherSum - sum);
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int take = solve (idx + 1, sum + stones[idx],stones,tot);
        int skip = solve (idx + 1, sum, stones, tot);
        return dp[idx][sum] = Math.min(take,skip);
    }
}
