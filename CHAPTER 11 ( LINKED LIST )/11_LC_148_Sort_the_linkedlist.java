Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 





// Definition for a singly-linked list node.
class ListNode {
    int val;  // Stores the value of the node
    ListNode next;  // Pointer to the next node in the list

    ListNode(int val) {  // Constructor to initialize a node with a given value
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        ListNode middle = getMiddle(head);  // Find the middle node of the list
        ListNode nextToMiddle = middle.next;  // Save the reference to the second half
        middle.next = null;  // Break the linked list into two separate halves

        // Step 2: Recursively sort the two halves
        ListNode left = sortList(head);  // Sort the first half
        ListNode right = sortList(nextToMiddle);  // Sort the second half

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    /**
     * Helper function to find the middle of the linked list using slow and fast pointers.
     * This is used to split the linked list into two halves.
     */
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;  // Slow pointer moves one step at a time
        ListNode fast = head;  // Fast pointer moves two steps at a time

        // Move fast by two steps and slow by one step to find the middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;  // Move slow one step
            fast = fast.next.next;  // Move fast two steps
        }

        return slow;  // Slow pointer will be at the middle of the list
    }

    /**
     * Helper function to merge two sorted linked lists.
     * Uses the two-pointer technique to efficiently merge them in O(n) time.
     */
    private ListNode merge(ListNode left, ListNode right) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;  // Pointer to track the merged list

        // Merge the two sorted lists
        while (left != null && right != null) {
            if (left.val <= right.val) {  // If left node is smaller or equal, add it first
                current.next = left;
                left = left.next;  // Move left pointer
            } else {  // If right node is smaller, add it first
                current.next = right;
                right = right.next;  // Move right pointer
            }
            current = current.next;  // Move merged list pointer
        }

        // If there are remaining nodes in either list, append them
        if (left != null) {
            current.next = left;
        } else if (right != null) {
            current.next = right;
        }

        return dummy.next;  // Return the head of the merged sorted list
    }
}
