/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 

Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}


class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        int cnt = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                cnt += map.get(sum  - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
