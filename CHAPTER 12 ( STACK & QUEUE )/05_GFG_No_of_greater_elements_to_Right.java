







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

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};
        
        System.out.println(countGreaterBruteForce(arr, indices)); // Output: [6, 1]
    }
}

