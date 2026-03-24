// User function Template for Java
class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            int comp = target - arr[i];
            if(set.contains(comp)){
                res.add(comp);
                res.add(arr[i]);
                return res;
            }
            set.add(arr[i]);
        }
        return res;
    }
}
