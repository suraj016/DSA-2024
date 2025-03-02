Nearest Smaller Element
Programming
Stacks And Queues
easy
52.0% Success

650

20

Bookmark
Asked In:
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Input Format

The only argument given is integer array A.
Output Format

Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
For Example

Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
Explaination 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]




BRUTEFORCE APPROACH


public class NearestSmallerElement {
    public static int[] findNearestSmallerElements(int[] A) {
        int n = A.length;
        int[] G = new int[n]; // Result array
        Arrays.fill(G, -1); // Default value when no smaller element exists

        // Iterate over each element
        for (int i = 0; i < n; i++) {
            // Check all elements to the left of A[i]
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) { // Found nearest smaller element
                    G[i] = A[j];
                    break; // Stop searching once we find the nearest smaller element
                }
            }
        }

        return G;
    }


OPTIMIZED PART 

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public static int[] findNearestSmallerElements(int[] A) {
        int n = A.length;
        int[] G = new int[n]; // Result array
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of smaller elements

        for (int i = 0; i < n; i++) {
            // Remove all elements greater than or equal to A[i]
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            // If stack is empty, store -1; else, store the top of the stack
            if (stack.isEmpty()) {
                G[i] = -1;  // If stack is empty, no smaller element exists
            } else {
                G[i] = stack.peek();  // Otherwise, the top of the stack is the nearest smaller element
            }
            

            // Push current element for future comparison
            stack.push(A[i]);
        }

        return G;
    }

}
