class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
        
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low;j <= high - 1;j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,j,i);
            }
        }
        swap(arr,high,i+1);
        return i + 1;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
