Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true



import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        // Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate over each character in the input string
        for (char ch : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If the character is a closing bracket
            else {
                // If stack is empty, there is no corresponding opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element from the stack
                char top = stack.pop();

                // Check if the popped element matches the corresponding opening bracket
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false;  // Mismatch found, return false
                }
            }
        }
        
        // If stack is empty, all brackets are properly closed, return true
        // If stack is not empty, there are unmatched opening brackets, return false
        return stack.isEmpty();
    }
}
