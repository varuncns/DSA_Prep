package Arrays.Fundamentals;

// https://takeuforward.org/plus/dsa/arrays/fundamentals/left-rotate-array

// Time Complexity:O(n) because the code iterates through the input array nums once.
// Space Complexity:O(1) as it uses a constant amount of extra space, regardless of the input size.

class Solution {
    public void reverseArray(int[] array,int low,int high){
        while(low<high){
            int temp = array[low];
            array[low]=array[high];
            array[high]=temp;
            low++;
            high--;
        }
    }
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n-1);
        reverseArray(nums,0,n-1);
    }
}
