package desavitsky.sorting;

// Merge k Sorted Lists
public class Task23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;

        while (interval < size) {
            for (int i = 0; i < size - interval; i += 2 * interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return size > 0 ? lists[0] : null;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        rev(null, list1, list2);
        return list1.val < list2.val ? list1 : list2;
    }
    // 1 1 1 1 1 1 1 1
    // 2 2 2 2 - 8
    // 4 4 - 8
    // 8 - 8
    // 1 1 1 1 1 1 1 1
    // 2 1 1 1 1 1 1 - 2
    // 3 1 1 1 1 1 - 3
    // 4 1 1 1 1 - 4
    // 5 1 1 1 - 5
    // 6 1 1 - 6
    // 7 1  - 7
    // 8 - 8
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
}

class ListNode {
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