class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int m = 0;
        int h = n - 1;
        while(m <= h){
            if(nums[m] == 0){
                int t = nums[l];
                nums[l] = nums[m];
                nums[m] = t;
                l++;
                m++;
            }else if(nums[m] == 1){
                m++;
            }else{
                int t = nums[m];
                nums[m] = nums[h];
                nums[h] = t;
                h--;
            }
        }
    }
}
