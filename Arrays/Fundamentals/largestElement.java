package Arrays.Fundamentals;

// Time Complexity:O(n) - The code iterates through the input array 'nums' once to find the largest element.
// Space Complexity:O(1) - The code uses a constant amount of extra space, regardless of the input size.
class Solution {
    public int largestElement(int[] nums) {
        int n = nums.length;
        int maxElement=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(maxElement<nums[i]){
                maxElement=nums[i];
            }
        }
        return maxElement;
    }
}