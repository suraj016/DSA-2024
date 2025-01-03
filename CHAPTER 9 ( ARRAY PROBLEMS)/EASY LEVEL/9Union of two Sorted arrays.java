Find the union of two sorted array 

int[] arr1 = {1, 2, 4, 5, 6};
int[] arr2 = {2, 3, 5, 7};

Output: [1, 2, 3, 4, 5, 6, 7]


TWO POINTER METHOD 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> unionOfSortedArrays(int[] arr1, int[] arr2) {
        // Create a list to store the result
        List<Integer> result = new ArrayList<>();
        
        // Initialize two pointers for both arrays
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                // Add arr1[i] to result and move i
                result.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                // Add arr2[j] to result and move j
                result.add(arr2[j]);
                j++;
            } else {
                // If both elements are the same, add one of them to result and move both pointers
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        // If there are remaining elements in arr1, add them to result
        while (i < arr1.length) {
            result.add(arr1[i]);
            i++;
        }

        // If there are remaining elements in arr2, add them to result
        while (j < arr2.length) {
            result.add(arr2[j]);
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> union = solution.unionOfSortedArrays(arr1, arr2);
        System.out.println(union); // Output: [1, 2, 3, 4, 5, 6, 7]
    }
}


USING HASHSET 

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> unionOfSortedArrays(int[] arr1, int[] arr2) {
        // Create a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements from arr1 to the HashSet
        for (int num : arr1) {
            set.add(num);
        }
        
        // Add all elements from arr2 to the HashSet
        for (int num : arr2) {
            set.add(num);
        }
        
        // Convert the HashSet to a list and return it
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> union = solution.unionOfSortedArrays(arr1, arr2);
        System.out.println(union); // Output: [1, 2, 3, 4, 5, 6, 7]
    }
}
