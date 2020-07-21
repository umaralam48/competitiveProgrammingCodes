public class FlattenLL {
    public Node flatten(Node head) {
        if (head == null)
            return null;
        flattenRecursive(head);
        return head;
    }

    private Node flattenRecursive(Node head) {
        if (head == null)
            return null;
        Node curr = head;
        Node prev = null;
        Node temp = null;
        while (curr != null) {
            if (curr.child != null) {
                temp = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                Node childtail = flattenRecursive(curr.child);
                curr.child = null;
                if (temp != null)
                    temp.prev = childtail;
                childtail.next = temp;
                curr = childtail;

            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};