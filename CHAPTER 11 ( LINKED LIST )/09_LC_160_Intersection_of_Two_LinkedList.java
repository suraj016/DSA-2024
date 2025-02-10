Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, 
headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // HashSet to store nodes of the first linked list
        HashSet<ListNode> visited = new HashSet<>();

        // Traverse through list A and store its nodes in the HashSet
        ListNode currentA = headA;
        while (currentA != null) {
            visited.add(currentA);
            currentA = currentA.next;
        }

        // Traverse through list B and check for the intersection
        ListNode currentB = headB;
        while (currentB != null) {
            if (visited.contains(currentB)) {
                return currentB; // Found the intersection node
            }
            currentB = currentB.next;
        }

        // If no intersection, return null
        return null;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Calculate the lengths of both linked lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Find the difference in lengths
        int diff = Math.abs(lenA - lenB);

        // Align the longer list to the same starting level as the shorter list
        if (lenA > lenB) {
            headA = moveSteps(headA, diff);
        } else {
            headB = moveSteps(headB, diff);
        }

        // Traverse both lists together to find the intersection
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // Intersection found
            }
            headA = headA.next;
            headB = headB.next;
        }

        // No intersection found
        return null;
    }

    // Helper method to calculate the length of a linked list
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Helper method to move a pointer forward by 'steps'
    private ListNode moveSteps(ListNode head, int steps) {
        while (steps > 0 && head != null) {
            head = head.next;
            steps--;
        }
        return head;
    }
}

Time Complexity: O(N + M), where:

N is the number of nodes in List A.
M is the number of nodes in List B.
Space Complexity: O(N),
