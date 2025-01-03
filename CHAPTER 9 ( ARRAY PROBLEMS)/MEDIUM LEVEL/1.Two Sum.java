Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


import java.util.Arrays;

class Solution {
    // This method returns an array of indices of the two numbers that add up to the target sum
    public int[] twoSum(int[] nums, int target) {
        // Step 1: Create a new array of pairs where each pair contains a number and its original index.
        // We do this to keep track of the original indices after sorting.
        int[][] indexedNums = new int[nums.length][2];  // Create an array to store value-index pairs.
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];  // Store the value of the number.
            indexedNums[i][1] = i;        // Store the original index of the number.
        }
        
        // Step 2: Sort the array based on the values (indexedNums[0] contains the value).
        // We use Arrays.sort() to sort the array of pairs based on the values.
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0])); // Sorting based on value at index 0.

        // Step 3: Initialize two pointers: one at the beginning (lo) and one at the end (ri).
        int lo = 0;               // Left pointer starts at the beginning of the array.
        int ri = nums.length - 1; // Right pointer starts at the end of the array.

        // Step 4: Use the two-pointer technique to find two numbers that add up to the target.
        while (lo < ri) {
            int sum = indexedNums[lo][0] + indexedNums[ri][0]; // Calculate the sum of the values at both pointers.
            
            // Step 5: If the sum is less than the target, move the left pointer to the right.
            if (sum < target) {
                lo++;  // Increase lo to try a larger value, as we need to get closer to the target.
            } 
            // Step 6: If the sum is greater than the target, move the right pointer to the left.
            else if (sum > target) {
                ri--;  // Decrease ri to try a smaller value.
            } 
            // Step 7: If the sum equals the target, return the indices.
            else {
                return new int[] {indexedNums[lo][1], indexedNums[ri][1]};  // Return the original indices.
            }
        }
        
        // Step 8: If no solution is found (though the problem guarantees a solution), return an empty array.
        return new int[] {};  // This should never be reached given the problem guarantees one solution.
    }
}
