package Linked_List;

import Linked_List.ListNode;

import java.util.*;

/**
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 */

public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0)
            return null;

        while (lists.length > 1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;   //handles case where odd no. of lists
                temp.add(merge(l1, l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : "\n"));
            result = result.next;
        }
    }
}
