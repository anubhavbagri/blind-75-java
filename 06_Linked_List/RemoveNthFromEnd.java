package Linked_List;

import Linked_List.ListNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len == n) return head.next;

        // find predecessor
        int i = 1;
        ListNode prev = head;
        while (i < (len - n)) {
            prev = prev.next;
            i++;
        }

        // remove node
        if (prev.next != null)
            prev.next = prev.next.next;

        return head;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : "\n"));
            result = result.next;
        }
    }
}