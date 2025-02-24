Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true


SOLUTION

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Step 1: Check if the lengths of both strings are the same
        // If the lengths are not the same, the strings cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create two HashMaps to store character mappings
        // map1: Maps characters from string 's' to string 't'
        // map2: Maps characters from string 't' to string 's'
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        // Step 3: Loop through the characters of both strings
        for (int i = 0; i < s.length(); i++) {
            // Get the current characters from both strings at position 'i'
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Step 4: Check if 'charS' has been mapped before in map1
            if (map1.containsKey(charS)) {
                // If it has been mapped, check if the mapping is correct
                // If the current mapping does not match the expected mapping in map1, return false
                if (map1.get(charS) != charT) {
                    return false;
                }
            } else {
                // If 'charS' hasn't been mapped yet, map it to 'charT'
                map1.put(charS, charT);
            }

            // Step 5: Check if 'charT' has been mapped before in map2
            if (map2.containsKey(charT)) {
                // If it has been mapped, check if the mapping is correct
                // If the current mapping does not match the expected mapping in map2, return false
                if (map2.get(charT) != charS) {
                    return false;
                }
            } else {
                // If 'charT' hasn't been mapped yet, map it to 'charS'
                map2.put(charT, charS);
            }
        }

        // Step 6: If no conflicts were found during the loop, return true
        // This means the strings are isomorphic, as every character has a valid one-to-one mapping
        return true;
    }
}


Time Complexity	O(n)