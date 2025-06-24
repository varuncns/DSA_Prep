// Time Complexity:The average and best case time complexity is O(n log n), and the worst case time complexity is O(n^2) due to the potential for unbalanced partitions.
// Space Complexity:The space complexity is O(log n) on average due to the recursive calls, and O(n) in the worst case.

// https://takeuforward.org/plus/dsa/sorting/algorithms/quick-sorting

class Solution {
    public int partitionFunction(int[] arr,int low,int high){
        int pivot=arr[low];
        int i =low;
        int j =high;
        while(i<j){
            //element greater than pivot
            while(arr[i]<=pivot && i<high){
                i++;
            }
            //element lesser than pivot
            while(arr[j]>pivot && j>low){
                j--;
            }
            //swap it
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        // j crossed i
        int temp2=arr[low];
        arr[low]=arr[j];
        arr[j]=temp2;
        return j;

    }
    public void quickSortHelper(int[] arr, int low,int high){
        if(low>=high){
            return;
        }
        int partitionIndex = partitionFunction(arr,low,high);
        quickSortHelper(arr,low,partitionIndex-1);
        quickSortHelper(arr,partitionIndex+1,high);
    }
    public int[] quickSort(int[] nums) {
        int n = nums.length;
        quickSortHelper(nums,0,n-1);
        return nums;
    }
}