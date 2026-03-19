class LRUCache {
    // Maximum capacity of cache
    private final int capacity;

    // ListNode : for Doubly Linked List
    class Node 
    {
        int key;
        int val;
        Node prev, next;

        Node(int key, int val) 
        {
            this.key = key;
            this.val = val;
        }
    }

    // Maps { Key -> Node }
    private Map<Integer, Node> cache; 

    // Dummy head and tail for D_LL
    private Node head, tail; 

    public LRUCache(int capacity) 
    {
        this.capacity = capacity;

        cache = new HashMap<>();

        // Initialize dummy nodes and Connect them
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) 
    {
        // If key is not in cache, return -1
        if (!cache.containsKey(key))
            return -1;

        // Move accessed node to Front (Most Recently Used)
        Node node = cache.get(key);
        moveToFront(node);

        return node.val;
    }

    public void put(int key, int value) 
    {
        // If key already exists
        if (cache.containsKey(key)) 
        {
            // Update existing node and move to front
            Node node = cache.get(key);
            node.val = value;

            moveToFront(node);
        }
        else 
        {
            // If capacity full, remove Least Recently Used node
            if (cache.size() == capacity) 
            {
                // LRU is Node before tail
                Node lru = tail.prev; 

                remove(lru);
                cache.remove(lru.key);
            }

            // Insert new node at Front
            Node newNode = new Node(key, value);

            addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    private void moveToFront(Node node) 
    {
        // Move : Remove and Add node to Front
        remove(node);
        addToFront(node);
    }

    private void remove(Node node) 
    {
        // Remove : update Node prev, next pointers
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) 
    {
        // Add : Connect newNode to Head and next Node
        node.prev = head;
        head.next.prev = node;

        node.next = head.next;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
