class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should return the head of the modified list.
    public Node pairwiseSwap(Node head) {
        // If the linked list is empty or has only one node, no swaps are needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize the previous and current nodes.
        Node prev = head;
        Node current = head.next;

        // Update the head to the second node since it will become the new head.
        head = current;

        while (true) {
            Node nextNode = current.next;
            current.next = prev;

            // If there are no more nodes to swap, break the loop.
            if (nextNode == null || nextNode.next == null) {
                prev.next = nextNode;
                break;
            }

            // Update the previous node's next pointer to the next pair's first node.
            prev.next = nextNode.next;

            // Move the pointers to the next pair.
            prev = nextNode;
            current = prev.next;
        }

        return head;
    }
}
