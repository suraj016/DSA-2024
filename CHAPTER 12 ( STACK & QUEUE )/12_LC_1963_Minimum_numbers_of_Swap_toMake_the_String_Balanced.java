You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

 

Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".



class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();

        // Traverse the string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                // Push open bracket into the stack
                st.push(ch);
            } else if (!st.isEmpty()) {
                // If we encounter a closing bracket and stack is not empty,
                // pop the top open bracket to balance it
                st.pop();
            }
        }

        // The size of the stack represents the number of unbalanced open brackets
        // Minimum swaps required = (size of stack + 1) / 2
        return (st.size() + 1) / 2;
    }
}
