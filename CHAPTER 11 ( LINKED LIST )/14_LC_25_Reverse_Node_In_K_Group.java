LEETCODE NO 25 REVERSE NODE IN K GROUP


Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the lists nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head; // No need to reverse if k is 1 or list is empty

        // Step 1: Count the number of nodes to ensure we have at least k nodes to reverse
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // If there are less than k nodes, return head (no reversal)
        if (count < k) return head;

        // Step 2: Reverse the first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 0;

        while (i < k && curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse current node's pointer
            prev = curr;      // Move prev to current
            curr = next;      // Move current to next
            i++;
        }

        // Step 3: Recursively call the function for the next group of k nodes
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Step 4: Return new head (prev now points to the first node of reversed group)
        return prev;
    }
}
