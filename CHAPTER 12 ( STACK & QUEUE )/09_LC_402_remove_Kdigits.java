Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";  // If we remove all digits, return "0"

        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            // Remove digits from stack while k > 0 and stack top is greater than current digit
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;  // Reduce k after each removal
            }
            stack.push(digit);
        }

        // If we still need to remove more digits, remove from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the final number from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();  // Reverse since stack stores in reverse order

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

}
 