Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106


class Solution {
    public ListNode oddEvenList(ListNode head) {
    // Edge case: If the list has less than 2 nodes, no reordering is needed
    if (head == null || head.next == null) {
        return head;
    }

    // Initialize pointers for odd and even lists
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenStart = head.next;

    // Traverse the list to group odd and even nodes
    while (even != null && even.next != null) {
        odd.next = even.next;  // Link current odd node to the next odd node
        odd = odd.next;        // Move the odd pointer forward

        even.next = odd.next;  // Link current even node to the next even node
        even = even.next;      // Move the even pointer forward
    }

    // Link the end of the odd list to the start of the even list
    odd.next = evenStart;

    // Return the head of the reordered list
    return head;
}

}

// TIME COMPLEXITY = O(N)
// SPACE COMPLEXITY = O(1)
