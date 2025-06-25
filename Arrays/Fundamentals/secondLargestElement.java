package Arrays.Fundamentals;

// Time Complexity:O(n) because it iterates through the array once.
// Space Complexity:O(1) because it uses a fixed amount of extra space.

class Solution {
    public int secondLargestElement(int[] nums) {
    if (nums == null || nums.length < 2) return -1;

    int maxFirst = Integer.MIN_VALUE;
    int maxSecond = Integer.MIN_VALUE;

    for (int num : nums) {
        if (num > maxFirst) {
            maxSecond = maxFirst;
            maxFirst = num;
        } else if (num < maxFirst && num > maxSecond) {
            maxSecond = num;
        }
    }

    return (maxSecond == Integer.MIN_VALUE) ? -1 : maxSecond;
}
}