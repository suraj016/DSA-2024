1. Lower Bound
The lower bound of a target element is the index of the first position where the element is greater than or equal to the target.
This means it’s the smallest index at which the target could appear in the sorted array.

If the element exists in the array, the lower bound points to its first occurrence.
If the element does not exist, the lower bound points to the index where the element could be inserted to maintain the sorted order.
Example of Lower Bound:
       arr = [1, 3, 3, 3, 5, 7, 9]
       Finding the Lower Bound
The lower bound of a target is the first position in the array where an element is greater than or equal to the target.

Target: 3
The first occurrence of 3 is at index 1 in the array.
Since the lower bound is the first position where the element is >= target, the lower bound of 3 is 1.
Target: 4 (not present in array)
There is no 4 in the array, so the lower bound points to the position where 4 could be inserted to maintain sorted order.
The smallest index where 4 could go while maintaining order is at index 4, just before 5.
So, the lower bound of 4 is 4.


.


public class BoundsBinarySearch {

    // Lower Bound: First position where arr[index] >= target
    public static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        int pa = arr.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                pa = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        
        return pa;
    }
}   