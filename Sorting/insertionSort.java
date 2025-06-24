// Time Complexity:
//     The time complexity is O(n^2) because of the nested loops, where the outer loop iterates n times, and the inner loop iterates up to i times in each iteration of the outer loop.
// Space Complexity:
//     The space complexity is O(1) because the algorithm sorts the array in-place, using only a constant amount of extra space for temporary variables.

// https://takeuforward.org/plus/dsa/sorting/algorithms/insertion-sorting

class Solution {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j = i;
            while(j>0){
                if(nums[j-1]>nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
                j--;
            }
        }
        return nums;
    }
}