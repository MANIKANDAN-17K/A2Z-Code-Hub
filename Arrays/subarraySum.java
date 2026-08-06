/*
560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
         int curr = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i < n ;i++){
            curr += nums[i];
            if(map.containsKey(curr - k)){
                res += map.get(curr-k);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return res;
    }
}
