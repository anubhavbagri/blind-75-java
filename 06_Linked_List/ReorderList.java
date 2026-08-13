package Linked_List;

import Linked_List.ListNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow becomes midpoint hence split & reverse the second half
        ListNode list2 = reverse(slow.next);
        slow.next = null;

        merge(head, list2);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        // stopping when second half is exhausted since that'll always be smaller(odd) or equal(even)
        while (list2 != null) {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;

            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }

        // list1 might be larger in case of odd no. of nodes
        if (list1 != null) {
            curr.next = list1;
        }

        return dummy.next;
    }

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

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : "\n"));
            head = head.next;
        }
    }
}