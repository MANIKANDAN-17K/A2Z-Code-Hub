/*
300. Longest Increasing Subsequence

Given an integer array nums, return the length of 
the longest strictly increasing .

 
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 

Constraints:

    1 <= nums.length <= 2500
    -104 <= nums[i] <= 104

 */


// brute force 


class Solution {
    
    public int lengthOfLIS(int[] nums) {
        return LIS(nums,0,-1);
    }
    private int LIS(int[] nums,int idx,int prev){
        if(idx == nums.length) return 0;
        int skip = LIS(nums,idx + 1,prev);
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + LIS(nums,idx + 1, idx);
        }
        return Math.max(skip,take);
    }
}

// better approach

class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return LIS(nums,0,-1);
    }
    private int LIS(int[] nums,int idx,int prev){
        if(idx == nums.length) return 0;
        if(dp[idx][prev + 1 ] != -1 ) return dp[idx][prev+1];
        int skip = LIS(nums,idx + 1,prev);
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + LIS(nums,idx + 1, idx);
        }
        return dp[idx][prev + 1] = Math.max(skip,take);
    }
}

// optimal approach

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int [n];
        int size = 0;
        for(int num : nums){
            int left = 0;
            int right = size;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(tail[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            tail[left] = num;
            if(size == left){
                size++;
            }
        }
        return size;
    }

}
