Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, 
otherwise return 0.



Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.

Examples:

Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
Output: 7
Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7. 
The number 33 is connected to the last node of the linkedlist to form the loop because according
 to the input the 4th node from the beginning(1 based indexing) 
will be connected to the last node for the loop.
 
Input: LinkedList: 5->4, c = 0
Output: 0
Explanation: There is no loop.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= no. of nodes <= 106
0 <= node.data <=106
0 <= c<= n-1

import java.util.HashSet;

class Solution {
    public int countLoopLength(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>(); // HashSet to store visited nodes
        ListNode current = head;

        while (current != null) {
            if (visitedNodes.contains(current)) { // If node is already visited, cycle starts here
                ListNode temp = current;
                int count = 1; // Start counting the loop length
                temp = temp.next;
                while (temp != current) { // Traverse until we reach the same node again
                    count++;
                    temp = temp.next;
                }
                return count; // Return the loop length
            }
            visitedNodes.add(current); // Mark node as visited
            current = current.next; // Move to the next node
        }

        return 0; // No cycle found
    }
}

// TIME COMPLEXITY = O(N);
// SPACE COMPLEXITY = O(N)



class Solution {
    public int countLoopLength(ListNode head) {
        if (head == null || head.next == null) return 0; // No cycle if list is empty or has one node

        ListNode slow = head, fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps

            if (slow == fast) { // Cycle detected
                // Step 2: Find the length of the cycle
                ListNode temp = slow;
                int count = 1;
                temp = temp.next;
                while (temp != slow) { // Traverse until we meet the same node again
                    count++;
                    temp = temp.next;
                }
                return count; // Return the loop length
            }
        }

        return 0; // No cycle found
    }
}

// TIME COMPLEXITY = O(N);
 // SPACE COMPLEXITY = O(1)

