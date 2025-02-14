     ADD TWO NUMBERS

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify the result list creation
        ListNode current = dummyHead; // Pointer to build the new list
        int carry = 0; // To handle carry during addition

        while (l1 != null || l2 != null) {
            int x = 0; // Value from l1
            int y = 0; // Value from l2

            // Assign values from l1 and l2 if they are not null
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next; // Move to the next node in l1
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next; // Move to the next node in l2
            }

            int sum = x + y + carry; // Calculate the sum of digits + carry
            carry = sum / 10; // Update carry for the next iteration
            current.next = new ListNode(sum % 10); // Create a new node for the digit
            current = current.next; // Move the pointer forward
        }

        // If there's still a carry left, add it as the last node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // Return the result list (skipping the dummy node)
    }
}
tc = O(n)
sc = O(1)