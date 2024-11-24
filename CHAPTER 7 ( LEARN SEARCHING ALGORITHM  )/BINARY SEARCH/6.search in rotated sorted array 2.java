LEETCODE NO 81  ->  Search in rotated sorted array 2

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104



BRUTE FORCE APPROACH - >  APPLY LINEAR SEARCH


        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;


OPTIMIZED APPROACH

 
 
int start = 0; 
int end = arr.length-1;

while(start <= end){
    int mid = start + (end-start)/2;
    if(arr[mid] == target){
        return true;
    }

    if(arr[start] == arr[mid]  && arr[mid] == arr[end]){  // if start ,mid and last are equal or not
        start = start+1;  // trim down from both the ends
        end= end-1;
        continue;

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
return false;
