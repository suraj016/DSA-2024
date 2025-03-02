







BRUTEFORCE


import java.util.*;

public class GreaterElementsToRight {
    public static List<Integer> countGreaterBruteForce(int[] arr, int[] indices) {
        List<Integer> result = new ArrayList<>();
        
        // Outer loop iterates through each query index
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i]; // Get the current query index
            int count = 0;
            
            // Inner loop checks elements to the right of the current index
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[j] > arr[index]) {
                    count++; // Increment count if arr[j] is strictly greater than arr[index]
                }
            }
            
            // Store the count for this query index
            result.add(count);
        }
        
        return result;
    }


 }



 import java.util.*;

public class GreaterElementsToRight {
    public static List<Integer> countGreaterWithStack(int[] arr, int[] indices) {
        int n = arr.length;
        int[] greaterCount = new int[n]; // Stores the count of greater elements for each index
        Stack<Integer> stack = new Stack<>(); // Monotonic decreasing stack
        List<Integer> result = new ArrayList<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove smaller elements from the stack
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // The number of greater elements to the right is the current stack size
            greaterCount[i] = stack.size();
            
            // Push current element into the stack
            stack.push(arr[i]);
        }
        
        // Answer queries in O(1) using precomputed greaterCount[]
        for (int index : indices) {
            result.add(greaterCount[index]);
        }
        
        return result;
    }

}



