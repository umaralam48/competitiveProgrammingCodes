import java.util.HashMap;

public class Cache<T> {
    public static void main(String[] args) {

    }

    private int capacity;
    private Node<T> head;
    private Node<T> tail;
    private HashMap<String, Node<T>> map;
    private long size;

    public Cache(int capacity) {
        // capacity is memory not number
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        map = new HashMap<String, Node<T>>();
        this.size = 0;

    }

    private int getSize(T obj) {
        return 0;
    }

    class Node<T> {
        public Node<T> next;
        public Node<T> prev;
        public String key;
        public T data;

        public Node(Node<T> next, Node<T> prev, String key, T data) {
            this.next = next;
            this.data = data;
            this.key = key;
            this.prev = prev;
        }
    }

    public T add(String key, T data) {
        if (map.size() + getSize(data) >= capacity) {
            Node<T> n = map.remove(head.key);

            size -= getSize(n.data);
            head = head.next;
            // adding to tail
            Node<T> temp = new Node<T>(null, tail, key, data);
            tail.next = temp;
            map.put(key, temp);
        } else {

            if (head == null) {
                head = new Node<T>(null, null, key, data);
                tail = head;
            } else {
                Node<T> temp = new Node<T>(null, tail, key, data);
                tail.next = temp;
            }
        }

        return data;
    }

    public T get(String key) {
        if (map.containsKey(key)) {
            Node<T> n = map.get(key);
            toTail(n);
            return n.data;
        } else {
            return null;
        }
    }

    public T delete(String key) {
        if (map.containsKey(key)) {
            Node<T> n = map.get(key);
            deleteNode(n);
            map.remove(key);
            return n.data;
        } else
            return null;
    }

    private void deleteNode(Cache<T>.Node<T> n) {
        // is head
        if (n.prev == null) {
            head = head.next;
            head.prev = null;
        }
        // is tail
        else if (n.next == null) {
            tail = n.prev;
            n.prev.next = null;

        } else {
            n.prev.next = n.next;
        }
    }

    private void toTail(Node<T> n) {
        n.prev.next = n.next;
        tail.next = n;
        n.next = null;
        tail = n;
    }

}
