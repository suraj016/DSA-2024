



//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

  
// BRUTEFORCE SOLUTION 

class Solution {
    public void moveZeroes(int[] nums) {
        // Create a temporary array to hold the non-zero elements
        // This array has the same length as the input array
        int[] temp = new int[nums.length];
        
        // `tempIndex` keeps track of the position in the temporary array
        // where the next non-zero element should be placed
        int tempIndex = 0;

        // Iterate through the original array to identify non-zero elements
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, copy it to the `temp` array
            if (nums[i] != 0) {
                temp[tempIndex] = nums[i];
                tempIndex++;  // Increment the index for the next non-zero element
            }
        }

        // At this point, the `temp` array contains all non-zero elements in their original order,
        // followed by zeros (because the array is initialized to zero by default in Java).

        // Copy the contents of the temporary array back to the original array
        // This overwrites the original array with the rearranged elements
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}

  OPTIMIZED APPROACH

  class Solution {
    public void moveZeroes(int[] nums) {
        // `j` will be used to keep track of the first occurrence of a zero
        // in the array. Initialize it to -1, which means no zero has been found yet.
        int j = -1;
        
        // Step 1: Find the first zero in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { 
                // If a zero is found, record its index in `j` and stop searching
                j = i;
                break; // Exit the loop since we only need the first zero
            }
        }

        // Step 2: If no zero is found, the array is already in the desired state
        if (j == -1) return; // Exit the function, as no further processing is needed
        
        // Step 3: Process the rest of the array, moving non-zero elements forward
        // and keeping zeros at the end
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) { 
                // When a non-zero element is found:
                // Swap it with the element at index `j` (the first zero's position)
                int temp = nums[j]; // Temporarily store the zero at index `j`
                nums[j] = nums[i]; // Move the non-zero element to index `j`
                nums[i] = temp;    // Place the zero at the current index `i`
                
                // Increment `j` to point to the next zero's position in the array
                j++;
            }
        }
    }
}

