class Solution {
    int stockBuySell(int arr[]) {
        int res = 0;
        for(int i =1 ;i<arr.length;i++){
            if(arr[i - 1] < arr[i]){
                res += arr[i] - arr[i - 1];
            }
        }
        return res;
    }
}
