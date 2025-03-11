Rat in a Maze Problem - I
Difficulty: MediumAccuracy: 35.75%Submissions: 323K+Points: 4Average Time: 25m
Consider a rat placed at position (0, 0) in an n x n square matrix mat. The rats goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list.+

The task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.

Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists and the destination cell is blocked.




import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();

    // Function to check if the given cell (i, j) is within maze boundaries
    boolean isSafe(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    // Recursive function to find paths in the maze
    void solve(int i, int j, int[][] m, int n, StringBuilder temp) {
        // If the current cell is out of bounds or blocked, return
        if (!isSafe(i, j, n) || m[i][j] == 0) {
            return;
        }
        
        // If the destination is reached, add the path to the result list
        if (i == n - 1 && j == n - 1) {
            result.add(temp.toString());
            return;
        }
        
        // Mark the cell as visited
        m[i][j] = 0;

        // Move Down
        temp.append('D');
        solve(i + 1, j, m, n, temp);
        temp.deleteCharAt(temp.length() - 1);
        
        // Move Right
        temp.append('R');
        solve(i, j + 1, m, n, temp);
        temp.deleteCharAt(temp.length() - 1);
        
        // Move Up
        temp.append('U');
        solve(i - 1, j, m, n, temp);
        temp.deleteCharAt(temp.length() - 1);
        
        // Move Left
        temp.append('L');
        solve(i, j - 1, m, n, temp);
        temp.deleteCharAt(temp.length() - 1);
        
        // Unmark the cell (backtrack)
        m[i][j] = 1;
    }

    // Function to find all paths from (0,0) to (n-1,n-1) in the maze
    List<String> findPath(int[][] m, int n) {
        result.clear(); // Clear previous results
        StringBuilder temp = new StringBuilder();
        solve(0, 0, m, n, temp);
        return result;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        Solution sol = new Solution();
        List<String> paths = sol.findPath(maze, maze.length);
        
        if (paths.isEmpty()) {
            System.out.println("No path found");
        } else {
            System.out.println("Paths: " + paths);
        }
    }
}
