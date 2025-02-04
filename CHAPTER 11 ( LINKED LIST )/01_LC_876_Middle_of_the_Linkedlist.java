Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100



Solutions 

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        // Step 1: Calculate the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Find the middle node
        int middleIndex = length / 2; // Index of the middle node (0-based)
        current = head;0.
    
        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }

        // Step 3: Return the middle node
        return current;
    }

    // TIME COMPLEXITY = O(N);
    // SPACE COMPLEXITY = O(1);




    public ListNode middleNode(ListNode head) {
    ListNode slow = head;  // slow pointer
    ListNode fast = head;  // fast pointer
    
    // Traverse the list with fast moving two steps and slow moving one step
    while (fast != null && fast.next != null) {
        slow = slow.next;     // Move slow pointer one step
        fast = fast.next.next; // Move fast pointer two steps
    }
    
    // When fast reaches the end, slow will be at the middle
    return slow;

    // TIME COMPLEXITY = O(N)
    // SPACE COMPLEXITY = O(1)
}

}
