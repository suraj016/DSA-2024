Delete all occurrences of a given key in a doubly linked list
Difficulty: MediumAccuracy: 50.04%Submissions: 42K+Points: 4Average Time: 30m
You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

Example1:

Input: 
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5
Explanation: 
All Occurences of 2 have been deleted.


public Node deleteAllOccurrences(Node head, int key) {
    if (head == null) return null; // If the list is empty, return null

    Node curr = head;

    // Traverse the list
    while (curr != null) {
        if (curr.data == key) {
            // If the node to be deleted is the head
            if (curr == head) {
                head = curr.next; // Move head forward
                if (head != null) {
                    head.prev = null; // Update new head's prev to null
                }
            } else {
                // Update previous node's next pointer
                curr.prev.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = curr.prev; // Update next node's prev pointer
                }
            }
        }
        curr = curr.next; // Move to the next node
    }
    
    return head; // Return the updated head
}

