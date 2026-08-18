package Linked_List;

import Linked_List.ListNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // pos = 1 means tail's next points to node at index 1 (value 2)
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        int pos = 1; // set to -1 for no cycle

        if (pos >= 0) {
            ListNode cycleEntry = head;
            for (int i = 0; i < pos; i++) {
                cycleEntry = cycleEntry.next;
            }
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = cycleEntry;
        }

        boolean result = hasCycle(head);
        System.out.println("Has cycle: " + result);
    }
}
