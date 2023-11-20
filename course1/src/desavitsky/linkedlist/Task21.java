package desavitsky.linkedlist;

import java.util.Queue;

// Merge Two Sorted Lists
public class Task21 {

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        rev(null, list1, list2);
        return list1.val < list2.val ? list1 : list2;
    }

    private static void rev(ListNode prevNode, ListNode cnd1, ListNode cnd2) {
        final var next = cnd1.val < cnd2.val ? cnd1 : cnd2;
        if (prevNode != null) prevNode.next = next;
        final var left = (next == cnd1 ? cnd2 : cnd1);
        if (next.next == null) {
            next.next = left;
            return;
        }
        rev(next, left, next.next);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
