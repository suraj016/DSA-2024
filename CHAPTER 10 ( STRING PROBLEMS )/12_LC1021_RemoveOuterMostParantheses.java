LEETCODE NO 1021

Problem Statement in Simple Words
You are given a string s that consists of valid parentheses (only ( and )), like "(()())(())".

Your task is to:

Break the string into smaller groups of parentheses called primitive parentheses strings.

A primitive string is a part of the parentheses that is balanced and cannot be split further into smaller balanced groups.
Example: For "(()())(())", the primitive strings are "(()())" and "(())".
For each primitive string, remove the outermost parentheses.

Example: "(()())" becomes "()()" (after removing the first and last parentheses).
"(())" becomes "()" (after removing its outermost parentheses).
Combine all the results into one string and return it.

Input: "(()())(())"

Split into primitives: "(()())" and "(())".
Remove outermost parentheses: "(()())" → "()()", "(())" → "()".
Combine: "()()" + "()" = "()()()".
Output: "()()()".
Input: "(()())(())(()(()))"

Split into primitives: "(()())", "(())", "(()(()))".
Remove outermost parentheses:
"(()())" → "()()"
"(())" → "()"
"(()(()))" → "(())".
Combine: "()()" + "()" + "(())" = "()()()(())".
Output: "()()()(())".

// INTUTION

Step 1: Initialize variables:

A balance counter to track depth.
A StringBuilder or result string to store the inner characters.
Step 2: Traverse the string:

For each character:
If its (, increment the balance.
Skip the character if its the first ( of a new group (when balance becomes 1).
If its ), decrement the balance.
Skip the character if its the last ) of a group (when balance becomes 0).
Add all other characters to the result.
Step 3: Return the result string.


class Solution {
    public String removeOuterParentheses(String s) {
        // StringBuilder to store the final result
        StringBuilder result = new StringBuilder();
        
        // A counter to track the balance of parentheses
        // `openCount` is increased for every '(' and decreased for every ')'
        int openCount = 0;
        
        // Loop through each character in the string
        for (char ch : s.toCharArray()) {
            // If we encounter a closing parenthesis ')'
            if (ch == ')') {
                // Decrease the count first because this might close the outermost pair
                openCount--;
            }
            
            // Add the character to the result only if it is **not** part of the outermost parentheses
            // We exclude the first '(' (when openCount == 0) and its matching ')' (when openCount == 1)
            if (openCount > 0) {
                result.append(ch);
            }
            
            // If we encounter an opening parenthesis '('
            if (ch == '(') {
                // Increase the count for the new open parenthesis
                openCount++;
            }
        }
        
        // Convert the StringBuilder to a string and return the final result
        return result.toString();
    }
}


// DRY FOR THIS

Iterating through each character in the input s = "(()())(())":

Idx Char	                   Action	                                  openCount  Result
0	(	Increment openCount. Outer parenthesis, so not added to result.	        1	""
1	(	Increment openCount. Add to result (not outermost anymore).           	2	"("
2	)	Add to result. Decrement openCount.                                   	1	"()"
3	(	Increment openCount. Add to result.	                                    2	"()("
4	)	Add to result. Decrement openCount.	                                    1	"()()"
5	)	Decrement openCount. Outer parenthesis, so not added to result.       	0	"()()"
6	(	Increment openCount. Outer parenthesis, so not added to result.	        1	"()()"
7	(	Increment openCount. Add to result.	                                    2	"()()("
8	)	Add to result. Decrement openCount.	                                    1	"()()()"
9	)	Decrement openCount. Outer parenthesis, so not added to result.	        0	"()()()"
