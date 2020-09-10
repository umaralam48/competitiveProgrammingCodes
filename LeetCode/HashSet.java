class MyHashSet {

    /** Initialize your data structure here. */
    private boolean elem[];

    public MyHashSet() {
        elem = new boolean[1000000];
    }

    public void add(int key) {
        elem[key] = true;
    }

    public void remove(int key) {
        elem[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return elem[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */