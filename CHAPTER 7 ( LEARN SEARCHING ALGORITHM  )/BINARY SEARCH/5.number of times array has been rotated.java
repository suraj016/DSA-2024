Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 


int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index =-1;
        while (low <= high) {
            int mid = (low + high) / 2;
              // normal sorted array
            if(arr[low] <= arr[high]){
                   if(arr[low] < ans){
                     index = arr[low];
                    ans = arr[low];
                   
                }
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if(arr[low] < ans){
                     index = arr[low];
                    ans = arr[low];

                    
                }
               
                

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                if(arr[mid] < ans){
                     index = arr[mid];
                    ans = arr[mid];
                   
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
