/*
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
public class _146_LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;

        // move node to the tail
        moveToTail(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            // move the updated node to the tail
            moveToTail(node);
            return;
        }

        if (cache.size() == capacity) {
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        cache.put(key, insert);

        // add the new node to the tail
        addToTail(insert);
    }

    private void moveToTail(Node node) {
        // remove node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // add to tail
        node.prev = tail.prev;
        node.next = tail;
        node.prev.next = node;
        tail.prev = node;
    }

    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        node.prev.next = node;
        tail.prev = node;
    }

    // Method 2
    // Used LinkedHashMap
    // Remember to import java.util.LinkedHashMap 
    private Map<Integer, Integer> lruCache;
    private int capacity;

    public LRUCache(int capacity) {
        lruCache = new LinkedHashMap<Integer, Integer>(0, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!lruCache.containsKey(key))
            return -1;
        return lruCache.get(key);
    }

    public void set(int key, int value) {
        lruCache.put(key, value);
        if (lruCache.size() > capacity) {
            Map.Entry<Integer, Integer> toEvict = null;
            for (Map.Entry<Integer, Integer> entry : lruCache.entrySet()) {
                toEvict = entry;
                break;
            }
            lruCache.remove(toEvict.getKey());
        }
    }
}