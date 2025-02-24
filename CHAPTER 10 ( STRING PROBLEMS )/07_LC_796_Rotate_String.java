Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

SOLUTION

class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are different; if they are, return false immediately
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s with itself to account for all possible rotations
        String doubled = s + s;

        // Check if goal is a substring of the doubled string
        return doubled.contains(goal);
    }
}


class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are different; if yes, return false immediately
        if (s.length() != goal.length()) {
            return false;
        }

        // Rotate the string one character at a time and check if it matches the goal
        StringBuilder rotated = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            // Move the first character to the end
            char firstChar = rotated.charAt(0);
            rotated.deleteCharAt(0);
            rotated.append(firstChar);

            // Check if the rotated string matches the goal
            if (rotated.toString().equals(goal)) {
                return true;
            }
        }

        // If no rotation matches the goal, return false
        return false;
    }
}

