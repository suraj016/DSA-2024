Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tails next pointer is connected to (0-indexed).
 It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 
// BRUTEFORCE METHOD USING HASHING CONCEPT

class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>(); // HashSet to store visited nodes
        ListNode current = head;

        while (current != null) {
            if (visitedNodes.contains(current)) { // If node is already visited, cycle starts here
                return current;
            }
            visitedNodes.add(current); // Mark node as visited
            current = current.next; // Move to the next node
        }

        return null; // If we reach null, there is no cycle
    }
}

// TIME COMPLEXITY = O(N);
 // SPACE COMPLEXITY = O(N)



 // OPTIMIZED APPROACH 

public class Solution {
    public static ListNode detectCycle(ListNode head) {
     if (head == null || head.next == null) {
         return null; // No cycle if the list is empty or has only one node
     }
 
     // Step 1: Detect if there is a cycle using slow and fast pointers
     ListNode slow = head;
     ListNode fast = head;
 
     while (fast != null && fast.next != null) {
         slow = slow.next;         // Move slow pointer one step
         fast = fast.next.next;    // Move fast pointer two steps
 
         // If slow meets fast, a cycle is detected
         if (slow == fast) {
             // Step 2: Find the starting node of the cycle
             ListNode p = head;    // Start a pointer from the head
             while (p != slow) {   // Move both pointers one step at a time
                 p = p.next;
                 slow = slow.next;
             }
             return p; // The starting node of the cycle
         }
     }
 
     return null; // No cycle found
 }
 
 }

 // TIME COMPLEXITY = O(N);
 // SPACE COMPLEXITY = O(1)