You are given a string num, representing a large integer. 
Return the largest-valued odd integer (as a string) that is a non-empty substring of num, 
or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
Example 2:

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".


BRUTEFORCE 

class Solution {
    public String largestOddNumber(String num) {
        String maxOdd = ""; // Store the largest odd number found

        // Generate all substrings
        for (int i = 0; i < num.length(); i++) {
            for (int j = i; j < num.length(); j++) {
                String sub = num.substring(i, j + 1); // Extract substring
                
                // Check if it's an odd number (last digit is odd)
                if ((sub.charAt(sub.length() - 1) - '0') % 2 == 1) {
                    // Compare lexicographically to find the maximum
                    if (maxOdd.compareTo(sub) < 0) {
                        maxOdd = sub;
                    }
                }
            }
        }
        return maxOdd;
    }
}
TC = O(n*2)


OPTIMIZED

class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the end to find the rightmost odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) { // Check if it's odd
                return num.substring(0, i + 1); // Return substring from start to this position
            }
        }
        return ""; // No odd number found
    }
}
 
TC = O(n)