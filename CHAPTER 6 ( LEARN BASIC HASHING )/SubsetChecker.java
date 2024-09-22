/*
 * BRUTE FORCE APPROACH
 * 
 * TIME COMPLEXITY = O(M*N)
 * SPACE COMPLEXITY = O(1)
 * 
 */


public class SubsetChecker{

    public static boolean isSubset(int[] arr1, int[] arr2, int m, int n) {
        // Iterate over each element in the second array
        for (int i = 0; i < n; i++) {
            boolean found = false;
            // Check if the element exists in the first array
            for (int j = 0; j < m; j++) {
                if (arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }
            // If any element is not found, return false
            if (!found) return false;
        }
        // If all elements are found, return true
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }



        
    }
}

/*
 * MID LEVEL APPROACH
 *  
 * TIME COMPLEXITY WILL BE O(m log m + n log n)
 * SPACE COMPLEXITY WILL BE  and O(1) 
 * 
 * 
 * 
 * 
 * 
 * import java.util.*;

public class Main {

    // Function to check if arr2 is a subset of arr1
    public static boolean isSubset(List<Integer> arr1, List<Integer> arr2) {

        // Sort both lists
        Collections.sort(arr1);
        Collections.sort(arr2);

        int i = 0, j = 0;

        // Traverse both lists using two pointers
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else if (arr1.get(i).equals(arr2.get(j))) {
                i++;
                j++;
            } else {
                // If an element in arr2 is not found in arr1
                return false;
            }
        }

        // If we have traversed all elements in arr2, it is a subset
        return (j == arr2.size());
    }

    public static void main(String[] args) {

        // Initialize arrays as ArrayLists
        List<Integer> arr1 = Arrays.asList(11, 1, 13, 21, 3, 7);
        List<Integer> arr2 = Arrays.asList(11, 3, 7, 1);

        // Check if arr2 is a subset of arr1
        if (isSubset(arr1, arr2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

 * 
 */


 /*
  * 
           OPTIMIZED  APPROACH

           TIME COMPLEXITY =  O(m + n)
           SPACE COMPLEXITY = O(m)

           import java.util.HashSet;
           import java.util.Set;

   public class SubsetChecker {

    public static boolean isSubsetUsingHashing(int[] arr1,
                                               int[] arr2)
    {
        // Create a hash set and insert all elements of arr1
        Set<Integer> hashSet = new HashSet<>();
        for (int num : arr1) {
            hashSet.add(num);
        }

        // Check each element of arr2 in the hash set
        for (int num : arr2) {
            if (!hashSet.contains(num)) {
                return false;
            }
        }

        // If all elements of arr2 are found in the hash set
        return true;
    }

    public static void main(String[] args)
    {
        int[] arr1 = { 11, 1, 13, 21, 3, 7 };
        int[] arr2 = { 11, 3, 7, 1 };

        if (isSubsetUsingHashing(arr1, arr2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}

  */

 



  




