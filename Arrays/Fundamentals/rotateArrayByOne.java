package Arrays.Fundamentals;
// https://takeuforward.org/plus/dsa/arrays/fundamentals/left-rotate-array-by-one

// Time Complexity:O(n), due to the single for loop iterating through almost all elements of the array.
// Space Complexity:O(1), as it uses a constant amount of extra space regardless of the input size.

class Solution {
    public void rotateArrayByOne(int[] nums) {
      int n = nums.length;
      if (n <= 1) return;
  
      int first = nums[0];
      for (int i = 1; i < n; i++) {
        nums[i - 1] = nums[i];
      }
      nums[n - 1] = first;
    }
  }
  
