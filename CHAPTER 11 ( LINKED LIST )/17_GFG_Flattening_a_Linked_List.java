Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom pointer to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and -> represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.

Examples:

Input:

Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
Input:
 
Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
Explanation:
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
Constraints:
0 <= n <= 100
1 <= number of nodes in sub-linked list(mi) <= 50
1 <= node->data <= 104



OPTIMIZED SOLUTION 

public class Solution {

    // Function to merge two sorted linked lists
    public Node mergeTwoLists(Node a, Node b) {
        // Create a dummy node to simplify the merging process
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and compare nodes
        while (a != null && b != null) {
            if (a.data < b.data) {
                current.bottom = a;  // Attach the smaller node to the result
                a = a.bottom;        // Move the pointer of the list with the smaller node
            } else {
                current.bottom = b;
                b = b.bottom;
            }
            current = current.bottom;  // Move the current pointer to the added node
        }

        // If there are remaining nodes in either list, attach them
        if (a != null) {
            current.bottom = a;
        } else {
            current.bottom = b;
        }

        // Return the merged list (skipping the dummy node)
        return dummy.bottom;
    }

    // Function to flatten the entire list using the above merge function
    public Node flatten(Node root) {
        // Edge case: if the root is null, return null
        if (root == null) return null;

        // Initialize the result as the root's first level
        Node result = root;

        // Iterate through each level (next pointer) and merge it with the result
        while (root != null && root.next != null) {
            // Merge the current list with the next level's list
            result = mergeTwoLists(result, root.next);
            // Move to the next node (next pointer)
            root = root.next;
        }

        // Return the fully flattened list
        return result;
    }
}


TC=O(NlogN)
SC=O(N)

NAIVE SOLUTION




public class Solution {

    // Function to flatten the linked list using an ArrayList
    public Node flatten(Node root) {
        // Edge case: if the root is null, return null
        if (root == null) return null;

        ArrayList<Integer> list = new ArrayList<>();

        // Step 1: Traverse the list and collect all node values (including bottom nodes)
        Node temp = root;
        while (temp != null) {
            Node bottomNode = temp;
            while (bottomNode != null) {
                list.add(bottomNode.data);  // Add bottom node's data to the list
                bottomNode = bottomNode.bottom;
            }
            temp = temp.next;  // Move to the next node in the next level
        }

        // Step 2: Sort the list
        Collections.sort(list);

        // Step 3: Rebuild the linked list with sorted values
        Node newHead = new Node(list.get(0));
        Node current = newHead;
        
        // Create the new list using sorted values
        for (int i = 1; i < list.size(); i++) {
            current.bottom = new Node(list.get(i));  // Create a new bottom node
            current = current.bottom;  // Move to the next bottom node
        }

        // Return the head of the flattened list
        return newHead;
    }
}

TC=O(N⋅K)
SC=O(1)