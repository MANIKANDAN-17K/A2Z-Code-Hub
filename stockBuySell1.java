class Solution {
    int stockBuySell(int arr[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < minPrice){
                minPrice =arr[i];
            }else{
                maxProfit = Math.max(maxProfit,arr[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
