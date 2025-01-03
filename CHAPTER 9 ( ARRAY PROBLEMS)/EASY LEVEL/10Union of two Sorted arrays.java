int[] arr1 = {1, 2, 4, 5, 6};
int[] arr2 = {2, 3, 5, 7};
 Output: [2, 5]






import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> intersectionOfSortedArrays(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++; // Move pointer i forward
            } else if (arr1[i] > arr2[j]) {
                j++; // Move pointer j forward
            } else {
                // If both elements are equal, add to result and move both pointers
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> intersection = solution.intersectionOfSortedArrays(arr1, arr2);
        System.out.println(intersection); // Output: [2, 5]
    }
}



USING HASHSET

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> intersectionOfArrays(int[] arr1, int[] arr2) {
        // Create a HashSet to store elements from arr1, ensuring uniqueness
        HashSet<Integer> set = new HashSet<>();
        // Create a List to store the result (intersection)
        List<Integer> result = new ArrayList<>();

        // Add all elements from arr1 to the HashSet
        // This will remove any duplicates from arr1 and store unique elements
        for (int num : arr1) {
            set.add(num);
        }

        // Traverse arr2 and check if each element is present in the set
        for (int num : arr2) {
            // If the current element of arr2 is found in the set, it's part of the intersection
            if (set.contains(num)) {
                result.add(num); // Add the element to the result list
                set.remove(num);  // Remove the element from the set to avoid duplicates in the result
            }
        }

        // Return the result list containing the intersection of arr1 and arr2
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        // Call the method to find the intersection
        List<Integer> intersection = solution.intersectionOfArrays(arr1, arr2);
        
        // Print the result
        System.out.println(intersection); // Output: [2, 5]
    }
}

