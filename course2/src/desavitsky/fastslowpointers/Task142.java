package desavitsky.fastslowpointers;

public class Task142 {
    public ListNode detectCycle(ListNode head) {
        var slow = head;
        var fast = head;

        if (head == null || head.next == null) return null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == slow) {
            var slow2 = head;
            while (slow2 != slow) {
                slow = slow.next;
                slow2 = slow2.next;
            }
            return slow2;
        } else return null;

    }
}
