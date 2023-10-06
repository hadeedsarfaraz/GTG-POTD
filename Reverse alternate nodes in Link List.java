class Solution {
    public static void rearrange(Node head) {
        if (head == null || head.next == null) {
            return; // No rearrangement needed for empty or single-node list
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even; // Store the head of even nodes

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = null; // Set the end of the odd list to null
        evenHead = reverseList(evenHead); // Reverse the even list
        odd.next = evenHead; // Append the reversed even list to the end of the odd list
    }

    // Function to reverse a linked list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
