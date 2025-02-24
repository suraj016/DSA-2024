Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


class Solution {
    public String reverseWords(String s) {
        // Step 1: Split the string into words using regex "\\s+" (handles multiple spaces)
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the words using StringBuilder
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" "); // Add space only between words
            }
        }

        // Step 3: Return the reversed string
        return result.toString();
    }
}


/*
 
   DRY RUN

   Step 1: Trim the String

s.trim();
Before trim: "hello world" (No leading or trailing spaces)
After trim: "hello world" (No change)
Step 2: Split the String into Words

String[] words = s.trim().split("\\s+");
Regex "\\s+" splits by one or more spaces.
Splitting "hello world" results in:

words = ["hello", "world"]
Effect: It separates words correctly.

Step 3: Reverse Words Using Loop

StringBuilder result = new StringBuilder();

for (int i = words.length - 1; i >= 0; i--) {
    result.append(words[i]);
    if (i > 0) {
        result.append(" "); // Add space only between words
    }
}
Loop Execution
i	words[i]	   result.append(words[i])	  if (i > 0) append(" ")	  Final result
1	"world"	         "world"                  	✅ (adds " ")	         "world "
0	"hello"	         "world hello"	            ❌ (No space at end)	     "world hello"


Step 4: Convert StringBuilder to String

return result.toString();
Final output: "world hello"





 */