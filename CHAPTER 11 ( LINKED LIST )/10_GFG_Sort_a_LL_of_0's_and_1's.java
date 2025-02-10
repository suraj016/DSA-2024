Given a linked list where nodes can contain values 0s, 1s, and 2s only. 
The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 
2s at the end of the linked list, and 1s in the middle of 0s and 2s.

Examples:

Input: LinkedList: 1->2->2->1->2->0->2->2
Output: 0->1->1->2->2->2->2->2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
 
Input: LinkedList: 2->2->0->1
Output: 0->1->2->2
Explanation: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.

Solution

class Solution {
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, return as it is.
        }

        // Dummy nodes for separate lists
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        // Pointers to the last nodes of the lists
        Node zeroTail = zeroDummy, oneTail = oneDummy, twoTail = twoDummy;

        // Traverse the original list and link nodes to respective lists
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        // Merge the three lists
        // Ensure the last node of each list points to the head of the next list
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null; // End the final list

        // The head of the merged list is the first valid list's head
        return zeroDummy.next;
    }
}

TC - O(n)
sc- O(1)