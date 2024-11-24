LEETCODE 33

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104


// BRUTE FORCE APPROACH  (LINEAR SEARCH)


for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        return i; // Return the index if the target is found
    }
  
}
return -1; // Return -1 if the target is not found


// OPTIMIZED APPROACH (BINARY SEARCH)

 
int start = 0; 
int end = arr.length-1;

while(start <= end){
    int mid = start + (end-start)/2;
    if(arr[mid] == target){
        return mid;
    }

    if(arr[start] <= arr[mid]) {  // left sorted array
       if(arr[start] <= target && target <= arr[mid]){   // if target is present in left sorted array or not then apply normal bs
              end = mid -1; // to trim down
       }else{
        start = mid +1;
       }
    }else{  // right part is sorted
           if(arr[mid] <= target && target <= arr[end]){  // if target is present in right sorted array or not then apply normal bs
              start = mid +1;
       }else{
          end = mid -1;
       }
    }

}
return -1;



