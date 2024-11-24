LEETCODE 162

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.



BRUTE FORCE METHOD 

class Solution {
    public int findPeakElement(int[] nums) {
        int peak = 0;
        for(int i = 0; i < nums.length-1; i++){
          
            if(nums[i] < nums[i+1]){
                 peak = i+1;
            }
           
        }
         return peak;
    }
}



OPTIMIZED METHOD

class Solution {
    public int findPeakElement(int[] arr) {

    int n = arr.length; // Size of array

       // Edge cases:
    if (n == 1) return 0;
    if (arr[0] > arr[1]) return 0;
    if (arr[n - 1] > arr[n - 2]) return n - 1;

    int low = 1, high = n - 2;
    while (low <= high) {
        int mid = (low + high) / 2;

        //If arr[mid] is the peak:
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
            return mid;

        // If we are in the left:
        if (arr[mid] > arr[mid - 1]) low = mid + 1;

        // If we are in the right:
        // Or, arr[mid] is a common point:
        else high = mid - 1;
    }
    // Dummy return statement
    return -1;
    




    }
}






