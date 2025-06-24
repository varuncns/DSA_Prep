// Time Complexity:
//     O(n^2) due to nested loops iterating through the input array.
// Space Complexity:O(1) 
//     because it sorts in place using a constant amount of extra space.

// https://takeuforward.org/plus/dsa/sorting/algorithms/selection-sort

class Solution {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums;
    }
}