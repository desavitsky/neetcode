package desavitsky.fastslowpointers;

class Task2130 {

    public static void main(String[] args) {
        var fourth = new ListNode(1);
        var third = new ListNode(2, fourth);
        var snd = new ListNode(4, third);
        var fst = new ListNode(5, snd);

        System.out.println(pairSum(fst));
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        var current = node;

        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static int pairSum(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var slow2 = reverse(slow);
        slow = head;
        var sum = 0;
        while (slow2 != null) {
            sum = Math.max(sum, slow.val + slow2.val);
            slow = slow.next;
            slow2 = slow2.next;
        }

        return sum;
    }
}