Add 1 to a Linked List Number

You are given a linked list where each element in the list is a node and have an integer data. 
You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 


SOLUTION 

BRUTEFORCE

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; this.next = null; }
}

public class AddOneToLinkedListBruteForce {

    // Function to add 1 to the number represented by the linked list
    public static ListNode addOne(ListNode head) {
        // Step 1: Convert the linked list into an integer number
        int num = 0;
        ListNode temp = head;
        while (temp != null) {
            num = num * 10 + temp.val; // Shift left and add current node's value
            temp = temp.next;
        }

        // Step 2: Add 1 to the number
        num += 1;

        // Step 3: Convert the updated number back into a linked list
        ListNode dummy = new ListNode(0); // Dummy node to start building new list
        ListNode curr = dummy;

        for (char digit : String.valueOf(num).toCharArray()) {
            curr.next = new ListNode(digit - '0'); // Convert character to integer and add to list
            curr = curr.next;
        }

        return dummy.next; // Return the new head of the updated linked list
    }

    TC = O(N)
    SC = O(N)

   
}


OPTIMIZED 

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class AddOneToLinkedList {
    
    public static ListNode addOne(ListNode head) {
        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Add 1 to the reversed list
        ListNode temp = head;
        int carry = 1; // Start with carry = 1 since we need to add 1
        
        while (temp != null) {
            temp.val += carry; // Add carry to the current node
            
            if (temp.val < 10) {
                carry = 0; // No carry needed
                break; // Exit the loop early
            } else {
                temp.val = 0; // Reset to 0 (as it became 10)
                carry = 1; // Carry propagates to the next node
            }

            if (temp.next == null && carry == 1) {
                // If we are at the last node and carry is still left, add a new node
                temp.next = new ListNode(1);
                carry = 0; // No more carry needed
                break;
            }
            
            temp = temp.next; // Move to the next node
        }

        // Step 3: Reverse the list back to the original order
        return reverse(head);
    }

    // Function to reverse a linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}

