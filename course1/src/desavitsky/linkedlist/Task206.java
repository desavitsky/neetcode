package desavitsky.linkedlist;

// Reverse Linked List
public class Task206 {
    public static void main(String[] args) {
        var tail = new ListNode(4);
        var third = new ListNode(3, tail);
        var snd = new ListNode(2, third);
        var head = new ListNode(1, snd);
        var node = reverseList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }

    // iterative
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        var current = head;


        while(current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    //recursive
    public static ListNode reverseList(ListNode head) {
        return changeDirection(head, null);
    }

    private static ListNode changeDirection(ListNode current, ListNode previous) {
        if (current == null) return previous;
        else {
            var next = current.next;
            current.next = previous;
            return changeDirection(next, current);
        }
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
