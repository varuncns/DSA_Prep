// Time Complexity:
//     The time complexity is O(n^2) due to the nested loops.
// Space Complexity:
//     The space complexity is O(1) as it uses constant extra space.

// https://takeuforward.org/plus/dsa/sorting/algorithms/bubble-sort

class Solution {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        // The inner loop logic could benefit from a comment explaining its purpose, which is to compare adjacent elements and swap them if they are in the wrong order.
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
}