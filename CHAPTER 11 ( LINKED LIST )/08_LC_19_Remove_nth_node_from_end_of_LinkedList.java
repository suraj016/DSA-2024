Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Find the length of the linked list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Step 2: Calculate the position to stop at (k = length - n)
        int k = length - n;
        
        // Step 3: Handle the case where the head node needs to be removed
        if (k == 0) {
            return head.next; // Skip the head node
        }
        
        // Step 4: Move temp to the (k-1)-th node
        temp = head;
        while (k > 1) {
            temp = temp.next;
            k--;
        }
        
        // Step 5: Delete the next node
        temp.next = temp.next.next;
        
        // Step 6: Return the updated list
        return head;
    }
}

Time Complexity: O(N)
Space Complexity: O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Initialize two pointers, fast and slow
        ListNode fast = head;
        ListNode slow = head;

        // Step 2: Move the fast pointer `n` steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Step 3: Check if the fast pointer reached the end
        // This means we need to remove the head node
        if (fast == null) {
            return head.next;
        }

        // Step 4: Move both fast and slow pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5: Remove the nth node from the end
     //   ListNode delNode = slow.next; // The node to be deleted
        slow.next = slow.next.next;  // Skip the deleted node

        // Step 6: Return the updated head
        return head;
    }
}

Time Complexity: O(N)
Space Complexity: O(1)
