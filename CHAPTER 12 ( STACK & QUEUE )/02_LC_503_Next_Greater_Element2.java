Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), 
return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesnt exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1s next greater number is 2; 
The number 2 cant find next greater number. 
The second 1s next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]




public static int[] nextGreaterElements(int[] nums) {
    int n = nums.length; // Store the length of the array
    int[] result = new int[n]; // Create a result array of the same size as nums

    Arrays.fill(result, -1); // Initialize result array with -1 (default value when no greater element is found)

    // Iterate through each element in the array
    for (int i = 0; i < n; i++) {
        // Check the next elements in a circular manner
        for (int j = i + 1; j < i + n + 1; j++) {
            int index = j % n; // Circular index to wrap around
            if (nums[index] > nums[i]) { // If we find a greater element
                result[i] = nums[index]; // Store it in the result array
                break; // Break out of the loop once the next greater element is found
            }
        }
    }
    return result; // Return the final result array
}



OPTIMIZED APPROACH 


int n = arr.length;
    int[] nge = new int[n]; // Array to store results
    Stack<Integer> stack = new Stack<>(); // Monotonic stack

    // Traverse the array from right to left
    for (int i = 2 * n - 1; i >= 0; i--) {
        int index = i % n; // Ensure circular index within range

        // Step 1: Remove smaller elements from the stack
        while (!stack.isEmpty() && stack.peek() <= arr[index]) {
            stack.pop();
        }

        // Step 2: Store the next greater element if found, otherwise store -1
        // (Only store results for the first pass of the array)
        if (i < n) { 
            if (stack.isEmpty()) {
                nge[index] = -1; // No greater element found
            } else {
                nge[index] = stack.peek(); // Top element is the next greater element
            }
        }

        // Step 3: Push the current element onto the stack
        stack.push(arr[index]);
    }

    return nge;