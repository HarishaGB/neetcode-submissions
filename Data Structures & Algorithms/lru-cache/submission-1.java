class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final HashMap<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Add node just before tail
    private void addToTail(Node node) {
        Node prevNode = tail.prev;

        prevNode.next = node;
        node.prev = prevNode;

        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // This key was just used,
        // so move it to MRU position.
        remove(node);
        addToTail(node);

        return node.value;
    }

    public void put(int key, int value) {
        // Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);

            // Update value
            node.value = value;

            // Move to MRU position
            remove(node);
            addToTail(node);

            return;
        }

        // Create new node
        Node newNode = new Node(key, value);

        map.put(key, newNode);
        addToTail(newNode);

        // Cache exceeded capacity
        if (map.size() > capacity) {
            // LRU node is right after head
            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}
