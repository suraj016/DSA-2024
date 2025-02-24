 LEETCODE NO 1021   A valid parentheses 

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.


SOLUTION 


class Solution {
    public String removeOuterParentheses(String s) {
        // StringBuilder to store the result string without outermost parentheses
        StringBuilder result = new StringBuilder();

        // Variable to track the depth of parentheses nesting
        int depth = 0;

        // Loop through each character in the input string
        for (char ch : s.toCharArray()) {
            // If the character is an opening parenthesis '('
            if (ch == '(') {
                // If depth > 0, it means it's NOT an outermost parenthesis
                // So we add it to the result
                if (depth > 0) {
                    result.append(ch);
                }
                // Increase depth since we encountered an opening parenthesis
                depth++;
            } 
            // If the character is a closing parenthesis ')'
            else {
                // Decrease depth first because this ')' is closing a '('
                depth--;

                // If depth > 0, it means it's NOT an outermost parenthesis
                // So we add it to the result
                if (depth > 0) {
                    result.append(ch);
                }
            }
        }
        
        // Convert StringBuilder to a String and return the final result
        return result.toString();
    }

     }
 

 
 /*
  

 Approach to Solve the Problem
We need to remove the outermost parentheses of every primitive valid parentheses string in the given input.

Understanding Primitive Decomposition
A valid parentheses string can be broken down into primitive components. A primitive valid parentheses string is one that:

Is non-empty.
Cannot be split into two non-empty valid parentheses strings.
For example:

"(()())(())" can be decomposed into (()()) and (()).
Key Observations
Each primitive starts when we encounter an opening parenthesis '(' and ends when we encounter the corresponding 
closing parenthesis ')'.
The outermost parentheses are the first ( and the last ) of each primitive.
We need to track the depth of the parentheses to determine whether a ( or ) is an outermost one.
Efficient Approach Using a Counter (depth)
We use a counter (depth) to track the nesting level of the parentheses:

When encountering '(', if depth > 0, it is not an outermost parenthesis, so we add it to the result.
Increase depth after processing '(' to update the level.
When encountering ')', decrease depth first to update the level.
If depth > 0 after decrementing, it means the ')' is not an outermost parenthesis, so we add it to the result.



  */