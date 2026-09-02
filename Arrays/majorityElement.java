class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int e1 = -1;
        int e2 = -1;
        int n = nums.length;
        for(int i = 0;i<n;++i){
            if(c1 == 0 && nums[i] != e2){
                c1 = 1;
                e1 = nums[i];
            }else if(c2 == 0 && nums[i] != e1){
                c2 = 1;                e2 = nums[i];
            }else if(e1 == nums[i]){
                ++c1;
            }else if(e2 == nums[i]){
                ++c2;
            }else{
                --c1;
                --c2;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == e1) ++c1;
            if(nums[i] == e2) ++c2;
        }
        int min = n / 3;
        ArrayList<Integer> ans = new ArrayList<>();
        if(c1 > min) ans.add(e1);
        if(c2 > min && e1 != e2) ans.add(e2);
        return ans;
    }
}
