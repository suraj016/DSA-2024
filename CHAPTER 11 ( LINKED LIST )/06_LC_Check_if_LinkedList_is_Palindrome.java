Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>(); // Store values in an array list

        ListNode current = head;
        while (current != null) { // Traverse and store values
            list.add(current.val);
            current = current.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) { // Two-pointer check
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true; // If all elements matched, it's a palindrome
    }
}
// TIME COMPLEXITY = O(N)
// SPACE COMPLEXITY = O(N)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // Edge case: Empty or single node list

        // Step 1: Find the middle node (slow will point to the middle)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half of the list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // Step 3: Compare first and second half
        ListNode temp = secondHalf;
        boolean isPalindrome = true;
        while (temp != null) { // Check values
            if (firstHalf.val != temp.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4: Restore the original list (optional)
        reverseList(secondHalf);

        return isPalindrome;
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // New head of reversed list
    }
}

// TIME COMPLEXITY = O(N)
// SPACE COMPLEXITY = O(1)




