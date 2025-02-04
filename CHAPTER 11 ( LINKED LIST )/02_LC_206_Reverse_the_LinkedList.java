 //               REVERSE THE LINKEDLIST

 Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

// SOLUTIONS 

// 1. BRUTEFORCE METHOD  store the ll in arraylist, reverse the arraylist, reconnect the nodes based on the reversed list
   
import java.util.*;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // Base case: if list is empty or has one node

        List<ListNode> nodeList = new ArrayList<>(); // Create an ArrayList to store nodes
        ListNode current = head;

        // Step 1: Store all nodes in a list
        while (current != null) {
            nodeList.add(current); // Add current node to list
            current = current.next; // Move to the next node
        }

        // Step 2: Reconnect nodes in reverse order
        for (int i = nodeList.size() - 1; i > 0; i--) {
            nodeList.get(i).next = nodeList.get(i - 1); // Set the next pointer of each node to the previous one
        }
        nodeList.get(0).next = null; // The last node should point to null (end of reversed list)

        return nodeList.get(nodeList.size() - 1); // Return the new head (last node in original list)
    }
}


Time Complexity = O(N) + O(N) = O(N)
Space Complexity = O(N)

// OPTIMIZED SOLUTIONS

class Solution {
    public static ListNode reverseList(ListNode head) {
    ListNode prev = null;  // Previous node
    ListNode curr = head; // Current node
    ListNode next = null; // Temporary pointer for the next node

    while (curr != null) {
        next = curr.next;  // Save the reference to the next node
        curr.next = prev;  // Reverse the current node's link
        prev = curr;       // Move 'prev' one step forward
        curr = next;       // Move 'curr' one step forward
    }

    return prev; // 'prev' will be the new head of the reversed list
}

}

Time Complexity = O(N)
Space Complexity = O(1)
