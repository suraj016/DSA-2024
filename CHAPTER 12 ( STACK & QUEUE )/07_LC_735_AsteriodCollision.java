// leetcode no 735
 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.


class Solution {
    public int[] asteroidCollision(int[] arr) {
          Stack<Integer> stack = new Stack<>(); // Stack to store the asteroids
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() > 0 && arr[i] < 0) {
                int sum = stack.peek() + arr[i]; // Check the sum of the top element and the current asteroid
                
                if (sum < 0) { 
                    stack.pop(); // If sum < 0, the top asteroid explodes
                } else if (sum > 0) { 
                    arr[i] = 0; // If sum > 0, the current asteroid explodes
                } else { 
                    stack.pop(); // If sum == 0, both explode
                    arr[i] = 0;
                }
            }
            
            if (arr[i] != 0) {
                stack.push(arr[i]); // If the asteroid survived, push it to the stack
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        
        return result;
    }
}