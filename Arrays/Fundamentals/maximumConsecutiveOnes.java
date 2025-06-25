package Arrays.Fundamentals;

// https://takeuforward.org/plus/dsa/arrays/fundamentals/maximum-consecutive-ones
// Time Complexity:O(n) because the code iterates through the input array nums once.
// Space Complexity:O(1) as it uses a constant amount of extra space, regardless of the input size.

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOnes=0;
        int n = nums.length;
        int maxOnes=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                countOnes++;
            }
            else if(nums[i]==0){
                maxOnes=Math.max(countOnes,maxOnes);
                countOnes=0;
            }
        }
        maxOnes=Math.max(countOnes,maxOnes);
        return maxOnes;
    }
}