LEETCODE 520

We define the usage of capitals in a word to be right when one of the following cases holds:

CONDITION NEEDS TO BE true
. all letters are capitals      ex - BAT
. all letters are not capitals  ex - bat
. only first letter is capital  ex - Bat

 

Example 1:

Input: word = "USA"
Output: true

Example 2:
Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.

// SOLUTION NO 1
 
 in this problem first we will traverse the whole string and check letter by letter that if it is capital letter(WORD), 
 small letter(word) or first letter of word is capital and other is small (Word) and make two different functions for 
 capital and small.

class Solution {
    // Helper method to check if all characters are uppercase
    private boolean allCapital(String word) {
        for (char ch : word.toCharArray()) {
            // If any character is not between 'A' and 'Z', return false
            if (ch < 'A' || ch > 'Z') {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if all characters are lowercase
    private boolean allSmall(String word) {
        for (char ch : word.toCharArray()) {
            // If any character is not between 'a' and 'z', return false
            if (ch < 'a' || ch > 'z') {
                return false;
            }
        }
        return true;
    }

    
    public boolean detectCapitalUse(String word) {
        // Check if the entire word is uppercase, lowercase, 
        // or the first letter is uppercase and the rest lowercase
        if(allCapital(word) || allSmall(word) || 
               (Character.isUpperCase(word.charAt(0)) && allSmall(word.substring(1)))) {
                return true;
               }else{
                return false;
               }
    }
}

// SOLUTION NO 2

in this solution we will first initialize the countcapital variable which will tell that how many 
capital letters are there in a word ex - BALL (4), Cat(1)
now we got the count we will put if else condition and check if value of count = 0(no capital letter -> return true)
count = word.length(no of capital letter -> return true)
count = 1 and only first letter should be upper case only --> return true

if no condition satisfied return false

class Solution {
    public boolean detectCapitalUse(String word) {
        int countCapitals = 0; // Initialize a counter for uppercase letters

        // Iterate through each character in the word
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) { // Check if the character is uppercase
                countCapitals++;
            }
        }

        // Check if all letters are lowercase (no capitals)
        if (countCapitals == 0) {
            return true;
        }

        // Check if all letters are uppercase
        if (countCapitals == word.length()) {
            return true;
        }

        // Check if only the first letter is uppercase
        if (countCapitals == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        // If none of the conditions are satisfied, return false
        return false;
    }
}