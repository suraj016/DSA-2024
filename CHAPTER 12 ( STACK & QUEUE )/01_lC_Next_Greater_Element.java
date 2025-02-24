Next Greater Element (NGE) for every element in given Array
Last Updated : 12 Feb, 2025
Given an array arr[] of integers, the task is to find the Next Greater Element for each element of the 
array in order of their appearance in the array.
Note: The Next Greater Element for an element x is the first greater element on the right side of x in the array. 
Elements for which no greater element exist, consider the next greater element as -1. 

Examples: 

Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn’t exist, it is -1.


Input: arr[] = [6, 8, 0, 1, 3]
Output: [8, -1, 1, 3, -1]
Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , 
for 1 it is 3 and then for 3 there is no larger element on right and hence -1.


Input: arr[] = [50, 40, 30, 10]
Output: [-1, -1, -1, -1]
Explanation: There is no greater element for any of the elements in the array, so all are -1.


OPTIMIZED SOLUTION

public static int[] findNextGreaterElements(int[] arr) {
    int n = arr.length;
    int[] nge = new int[n]; // Array to store results
    Stack<Integer> stack = new Stack<>(); // Monotonic stack

    // Traverse the array from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Step 1: Remove smaller elements from the stack
        while (!stack.isEmpty() && stack.peek() <= arr[i]) {
            stack.pop();
        }

        // Step 2: If stack is empty, no greater element exists → store -1
        // Otherwise, store the top element of the stack
        if (stack.isEmpty()) {
            nge[i] = -1;
        } else {
            nge[i] = stack.peek();
        }

        // Step 3: Push the current element into the stack
        stack.push(arr[i]);
    }

    return nge;
}
