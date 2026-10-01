/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100

 */
class Solution {
    private boolean find(int[] nums,int idx,int tar){
        if(tar == 0) return true;
        if(idx == nums.length) return false;
        if(nums[idx] <= tar){
            boolean take = find(nums,idx + 1,nums[idx] - tar);
            if(take){
                return true;
            }
        }
        boolean skip = find(nums,idx + 1,tar);
        return skip;
    }
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for(int n : nums)
            tot += n;
        if(tot % 2 != 0) return false;
        return find(nums,0,tot/2);
    }
}

class Solution {
    private boolean find(int[] nums,int idx,int tar,Boolean[][] dp){
        if(tar == 0) return true;
        if(idx == nums.length) return false;
        if(dp[idx][tar] != null) return dp[idx][tar];
        boolean take = false;
        if(nums[idx] <= tar){
            take = find(nums,idx + 1,tar - nums[idx],dp);          
        }
        boolean skip = find(nums,idx + 1,tar,dp);
        dp[idx][tar] = take || skip;
        return dp[idx][tar];
    }
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for(int n : nums)
            tot += n;
        if(tot % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length][tot/2 + 1];
        return find(nums,0,tot/2,dp);
    }
}
