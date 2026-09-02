class Solution {
    public int maxProduct(int[] nums) {
        int l2r = 1;
        int r2l = 1;
        int max = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(l2r == 0) l2r = 1;
            if(r2l == 0) r2l = 1;
            l2r *= nums[i];
            r2l *= nums[nums.length - i - 1];
            max = Math.max(max,Math.max(l2r,r2l));
        }
        return max;
    }
}
