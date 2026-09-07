/*
42. Trapping Rain Water
Solved
Hard
Topics
premium lock iconCompanies

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for(int i = 1;i<n - 1;i++){
            int l = height[i];
            for(int j = 0;j<i;j++){
                l = Math.max(l,height[j]);
            }
            int r = height[i];
            for(int j = i+1;j<n;j++){
                r = Math.max(r,height[j]);
            }
            res += Math.min(l,r) - height[i];
        }
        return res;
    }
}


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = height[0];
        for(int i = 1;i<n;i++){
            l[i] = Math.max(l[i-1],height[i]);
        }
        r[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            r[i] = Math.max(r[i+1],height[i]);
        }
        int min = 0;
        int res = 0;
        for(int i = 0;i<n;i++){
            min = Math.min(l[i],r[i]);
            res += min - height[i];
        }
        return res;
    }
}


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 1;
        int r = n - 2;
        int lm = height[l - 1];
        int rm = height[r + 1];
        int res = 0;
        while(l<=r){
            if(rm <= lm){
                res += Math.max(0,rm - height[r]);
                rm = Math.max(rm,height[r]);
                r--;
            }else{
                res += Math.max(0,lm - height[l]);
                lm = Math.max(lm,height[l]);
                l++;
            }
        }
        return res;
    }
}
