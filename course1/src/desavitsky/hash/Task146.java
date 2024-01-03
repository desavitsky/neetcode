package desavitsky.hash;

import java.util.*;

public class Task146 {

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

}

class LRUCache {

    private final int capacity;
    private Map<Integer, Node> cache;

    private Node left; // least-recent
    private Node right; // most-recent


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    private void insert(Node node) {
        var prevLast = right.prev;
        right.prev = node;
        prevLast.next = node;
        node.next = right;
        node.prev = prevLast;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public int get(int key) {
        var value = cache.get(key);
        if (value != null) {
            remove(value);
            insert(value);
        }
        return (value == null) ? -1 : value.val;
    }

    public void put(int key, int value) {
        var existing = cache.get(key);
        var node = new Node(key, value);
        if (existing == null) {
            cache.put(key, node);
            insert(node);
            if (cache.size() > capacity) {
                cache.remove(left.next.key);
                remove(left.next);
            }
        } else {
            remove(existing);
            insert(node);
            cache.put(key, node);
        }
    }

    private class Node {

        private final int key;
        private final int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return STR."NODE[key = \{key}, value = \{val}}";
        }
    }
}