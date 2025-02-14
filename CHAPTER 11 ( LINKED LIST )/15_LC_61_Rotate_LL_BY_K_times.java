LEETCODE NO 61   ROTATE LINKEDLIST BY K TIMES 



Given the head of a linked list, rotate the list to the right by k places.

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
     // Edge case: If the list is empty, has only one element, or no rotation needed
     if (head == null || head.next == null || k == 0) {
         return head; // Return the list as is
     }
 
     // Step 1: Find the length of the linked list
     ListNode temp = head;
     int length = 1; // We have at least one node, so start from 1
     while (temp.next != null) { 
         temp = temp.next; // Traverse the list to the end
         length++; // Count each node as we go
     }
 
     // Step 2: Compute the effective rotations needed
     // If k is larger than the length, rotating k times is equivalent to rotating k % length times
     k = k % length;
     
     // If k is 0 after the modulo operation, the list remains unchanged, so return the head
     if (k == 0) {
         return head;
     }
 
     // Step 3: Convert the list into a circular linked list
     // To do this, we connect the last node's next to the head of the list
     temp.next = head; // Connect tail to head to form a cycle
 
     // Step 4: Find the new tail, which will be at position (length - k - 1) from the start
     // The new head will be at position (length - k)
     int stepsToNewTail = length - k;
     ListNode newTail = head;
     
     // Traverse to the new tail node, which is (length - k - 1) steps from the start
     for (int i = 1; i < stepsToNewTail; i++) {
         newTail = newTail.next; // Move to the next node
     }
 
     // Step 5: Break the cycle and set the new head
     ListNode newHead = newTail.next; // The new head is the next node of the new tail
     newTail.next = null; // Break the cycle by setting the new tail's next to null
 
     // Return the new head of the rotated list
     return newHead;
 }
 
 }