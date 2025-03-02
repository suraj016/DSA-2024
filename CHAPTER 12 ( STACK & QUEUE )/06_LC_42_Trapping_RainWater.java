
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array 
[0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9



BRUTEFORCE

        int n = height.length;
        int totalWater = 0;
        
        for (int i = 0; i < n; i++) {
            int maxLeft = 0, maxRight = 0;
            
            // Find max height to the left
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            
            // Find max height to the right
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            
            // Calculate trapped water
            totalWater += Math.min(maxLeft, maxRight) - height[i];
        }
        
        return totalWater;

OPTIMIZED

int left = 0, right = height.length - 1; // Two pointers
int maxLeft = 0, maxRight = 0; // Track max heights on both sides
int totalWater = 0; // Stores total trapped water

while (left < right) {
    if (height[left] <= height[right]) { // Process the smaller boundary first
        if (height[left] >= maxLeft) {
            maxLeft = height[left]; // Update maxLeft
        } else {
            totalWater += maxLeft - height[left]; // Water trapped at left index
        }
        left++; // Move left pointer rightward
    } else {
        if (height[right] >= maxRight) {
            maxRight = height[right]; // Update maxRight
        } else {
            totalWater += maxRight - height[right]; // Water trapped at right index
        }
        right--; // Move right pointer leftward
    }
}

return totalWater;

tc-O(n) sc- O(1)