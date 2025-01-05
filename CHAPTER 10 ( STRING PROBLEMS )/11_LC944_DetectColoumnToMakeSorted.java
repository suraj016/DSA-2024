LEETCODE NO 944
 
You are given an array of n strings strs, all of the same length k.
The strings can be arranged such that there is one on each line, making a grid.

For example, 
strs = ["abc", "bce", "cae"] can be arranged as follows:
 VISUALIZE THIS AS 2-D ARRAY

           c b a
           d a f
           g h i
  

           Column 0 (['c', 'd', 'g']): Sorted.
           Column 1 (['b', 'a', 'h']): Not sorted (because a < b).
           Column 2 (['a', 'f', 'i']): Sorted.
           Unsorted columns: 1
           Output: 1

 


 // SOLUTION NO 1
 
 so basically iterate coloumn by coloumn in which check if present value is small then previous one 
 if it is there increment count variable , break and check for all rows and at last return the value 
 of count.
 
  

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;   // Number of strings
        int k = strs[0].length(); // Length of each string (assuming all strings are of equal length)
        int count = 0;         // Counter for columns to be deleted

        // Iterate over each column
        for (int i = 0; i < k; i++) {
            // Check the current column for unsorted rows
            for (int j = 1; j < n; j++) {
                // Compare characters in the current column of consecutive rows
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;  // Increment count if the column is unsorted
                    break;    // Stop checking further rows in this column
                }
            }
        }
        return count; // Return the total number of columns to be deleted
    }
}






 
