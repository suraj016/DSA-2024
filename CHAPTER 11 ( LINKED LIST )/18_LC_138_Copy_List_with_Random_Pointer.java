A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a copy of each node and place it next to the original node
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);  // Create a new node
            newNode.next = curr.next;           // Link the new node to the next original node
            curr.next = newNode;                // Place the new node after the original node
            curr = newNode.next;                // Move to the next original node
        }

        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;  // Copy the random pointer to the new node
            }
            curr = curr.next.next;  // Move to the next original node
        }

        // Step 3: Separate the copied list from the original list
        curr = head;
        Node newHead = head.next;  // Head of the new copied list
        Node copy = newHead;

        while (curr != null) {
            curr.next = curr.next.next;  // Restore the original list
            if (copy.next != null) {
                copy.next = copy.next.next;  // Fix the copied list next pointers
            }
            curr = curr.next;
            copy = copy.next;
        }

        return newHead;  // Return the deep copied list
    }

}