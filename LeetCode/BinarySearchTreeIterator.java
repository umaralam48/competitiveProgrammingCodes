import java.util.LinkedList;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {

    }

}

class BSTIterator {
    private LinkedList<TreeNode> ll;

    public BSTIterator(TreeNode root) {
        this.ll = new LinkedList<>();
        while (root != null) {
            ll.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode last = ll.pollLast();
        if (last.right != null) {
            TreeNode rl = last.right;
            while (rl != null) {
                ll.add(rl);
                rl = rl.left;
            }
        }
        return last.val;
    }

    public boolean hasNext() {
        return ll.size() > 0;
    }
}
