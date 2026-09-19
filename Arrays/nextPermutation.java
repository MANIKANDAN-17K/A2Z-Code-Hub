/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 

Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
    The input is generated such that a majority element will exist in the array.
*/
class Solution {
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int nums[],int i,int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n - 1;i>0;i--){
            if(nums[i] > nums[i-1]){
                idx = i - 1;
                break;
            }
        }
        if(idx == -1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i= n - 1;i>=idx;i--){
            if(nums[i] > nums[idx]){
                swap(nums,idx,i);
                break;
            }
        }
        reverse(nums,idx+1,n-1);
    }
}
