A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3


class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        // Traverse the string
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Push open parenthesis into the stack
                st.push(ch);
            } else { // ch == ')'
                if (!st.isEmpty() && st.peek() == '(') {
                    // If stack has an open parenthesis, pop to balance
                    st.pop();
                } else {
                    // Push unbalanced closing parenthesis
                    st.push(ch);
                }
            }
        }

        // The size of the stack represents the number of unbalanced parentheses
        return st.size();
    }
}
