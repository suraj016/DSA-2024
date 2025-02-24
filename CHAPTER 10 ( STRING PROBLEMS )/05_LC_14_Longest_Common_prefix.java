Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 


class Solution {
    public static String longestCommonPrefix(String[] strs) {
     // Step 1: Handle edge case when the input array is null or empty.
     // If the array is null or has no elements, there cannot be any common prefix.
     if (strs == null || strs.length == 0) {
         return ""; // Return an empty string since no common prefix can exist.
     }
 
     // Step 2: Initialize the prefix to the first string in the array.
     // This will serve as the starting point for comparisons.
     String prefix = strs[0];
 
     // Step 3: Iterate over the remaining strings in the array.
     // For each string, update the prefix by finding the common prefix between the current prefix and the string.
     for (int i = 1; i < strs.length; i++) {
         // Step 4: Call the helper function to find the common prefix between the current prefix and the next string.
         prefix = findCommonPrefix(prefix, strs[i]);
 
         // Step 5: If the common prefix becomes empty at any point, return an empty string.
         // This indicates that no common prefix exists between all strings.
         if (prefix.isEmpty()) {
             return ""; // Return an empty string when no common prefix is found.
         }
     }
 
     // Step 6: Return the final common prefix after processing all strings in the array.
     return prefix;
  }
 
  // Helper function to find the common prefix between two strings.
  private static String findCommonPrefix(String str1, String str2) {
     // Step 7: Use StringBuilder to efficiently build the common prefix.
     // StringBuilder is preferred for concatenation inside a loop for better performance.
     StringBuilder common = new StringBuilder();
 
     // Step 8: Determine the minimum length of the two strings to avoid going out of bounds during comparison.
     int minLength = Math.min(str1.length(), str2.length());
 
     // Step 9: Compare the characters of both strings one by one up to the minimum length.
     for (int i = 0; i < minLength; i++) {
         // Step 10: If the characters match, append them to the StringBuilder.
         // This adds the matching characters to the common prefix.
         if (str1.charAt(i) == str2.charAt(i)) {
             common.append(str1.charAt(i)); // Append the matching character.
         } else {
             // Step 11: If a mismatch is found, break the loop as the common prefix has ended.
             break;
         }
     }
 
     // Step 12: Convert the StringBuilder to a string and return it as the common prefix.
     return common.toString();
  }
 
 
 }