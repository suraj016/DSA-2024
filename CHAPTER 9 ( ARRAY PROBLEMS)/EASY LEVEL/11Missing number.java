Given an array nums containing n distinct numbers in the range [0, n],
 return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.


Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
2 is the missing number in the range since it does not appear in nums.


BRUTEFORCE

class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        
        // Outer loop to check each number from 0 to n
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            
            // Inner loop to check if the current number `i` exists in the array
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break; // No need to check further if the number is found
                }
            }
            
            // If `i` is not found in the array, it's the missing number
            if (!found) {
                return i;
            }
        }
        
        // Return -1 (optional, for safety, though this point won't be reached)
        return -1;
    }
    
}


BETTER APPROACH

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Create a boolean array `hash` to store presence of numbers
        int[] hash = new int[n + 1]; // The range is 0 to n, so we need n+1 size
        
        // Mark the presence of numbers in the array
        for (int i = 0; i < n; i++) {
            hash[arr[i]] = 1; // Mark the index corresponding to arr[i] as present
        }

        // Find the missing number
        for (int i = 0; i <= n; i++) {
            if (hash[i] == 0) {
                return i; // Return the missing number
            }
        }

        return -1; // This line is never reached if there is a missing number
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 0, 1}; // Example input
        System.out.println(solution.missingNumber(arr)); // Output: 2
    }
}



OPTIMIZED BY MATHS 


class Solution {
    public int missingNumber(int[] nums) {
          int n = nums.length;
          int sum = n*(n+1)/2;
          int s2 = 0;
          for(int i = 0; i < n; i++){
              s2 += nums[i];
           }
          return sum-s2;
        }
    }


BINARY SEARCH APPROACH


class Solution {
    public int missingNumber(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length;
        int ans = -1; // Variable to store the result

        // Step 2: Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > mid) {
                ans = mid; // Update `ans` with the current mid
                right = mid; // Narrow down to the left half
            } else {
                left = mid + 1; // Narrow down to the right half
            }
        }

        // If no number was skipped, the missing number is at `left` (equal to `nums.length`)
        return left == nums.length ? left : ans;
    }
}