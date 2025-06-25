package Arrays.Fundamentals;


// Time Complexity:O(n) because in the worst-case scenario, the loop iterates through all n elements of the array.
// Space Complexity:O(1) because it uses a constant amount of extra space, regardless of the input size.

class Solution {
    public int linearSearch(int nums[], int target) {
		int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
