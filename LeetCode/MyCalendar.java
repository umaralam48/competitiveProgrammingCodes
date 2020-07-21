/**
 * Calendar booking - checks clashes using Interval Trees
 * 
 * @author Mohd Umar Alam
 * @see IntervalTreeNode
 */
public class MyCalendar {
    private IntervalTreeNode root;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        IntervalTreeNode newNode = new IntervalTreeNode(start, end);
        if (root == null) {
            root = newNode;
            root.max = root.hi;
            return true;
        }
        if (search(root, newNode))
            return false;
        add(root, newNode);
        return true;
    }

    private IntervalTreeNode add(IntervalTreeNode node, IntervalTreeNode newNode) {
        if (node == null)
            return newNode;
        if (newNode.lo < node.lo) {
            node.left = add(node.left, newNode);
            node.max = Math.max(node.max, node.left.max);
        } else {
            node.right = add(node.right, newNode);
            node.max = Math.max(node.max, node.right.max);
        }
        return node;
    }

    private boolean search(IntervalTreeNode node, IntervalTreeNode newNode) {
        if (node == null)
            return false;
        if (node.intersects(newNode))
            return true;
        if (node.left == null)
            return search(node.right, newNode);
        if (node.left.max <= newNode.lo)
            return search(node.right, newNode);
        return search(node.left, newNode);
    }

}

class IntervalTreeNode {
    public int lo;
    public int max;
    public int hi;
    public IntervalTreeNode left;
    public IntervalTreeNode right;

    public IntervalTreeNode() {
    }

    public IntervalTreeNode(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.max = hi;
    }

    public boolean intersects(IntervalTreeNode that) {
        if (that.hi <= this.lo || that.lo >= this.hi)
            return false;
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */