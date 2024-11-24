2. Upper Bound

The upper bound of a target element is the index of the first position where the element is greater than the target. 
This means it’s the smallest index at which an element strictly greater than the target could appear.

If the element exists in the array, the upper bound points to the index just after the last occurrence of the target.
If the element does not exist, the upper bound is the index where an element larger than the target would be inserted.

2. Finding the Upper Bound
The upper bound of a target is the first position in the array where an element is strictly greater than the target.
   
arr = [1, 3, 3, 3, 5, 7, 9]
Finding the upper bound
 
Target: 3
The last occurrence of 3 is at index 3.
Since the upper bound is the first position where the element > target, the upper bound of 3 is 4 (just after the last 3).
Target: 4 (not present in array)
The smallest index where an element greater than 4 appears is also 4, as 5 is at index 4.
So, the upper bound of 4 is 4 (same as the lower bound in this case).



 // Upper Bound: First position where arr[index] > target
 public static int upperBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length;
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] <= target) {
            low = mid +1;;
        } else {
           high = mid -1;
        }
    }
    
    return low;
}