Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [4,5,6,7,1,2,3]
Explanation:
rotate 1 steps to the right: [2,3,4,5,6,7,1]
rotate 2 steps to the right: [3,4,5,6,7,1,2]
rotate 3 steps to the right: [4,5,6,7,1,2,3]


class Solution {

    public void reverse(int low, int high, int[] nums) {
        while (low < high) {
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
    }

    public void rotate(int[] nums, int k) {
        // Reduce k to within the bounds of the array size
        k = k % nums.length;
        
        // Handle edge cases
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }

        // Reverse the three parts of the array
        reverse(0, k - 1, nums);  // Reverse first part
        reverse(k, nums.length - 1, nums);  // Reverse second part
        reverse(0, nums.length - 1, nums);  // Reverse entire array
    }
}