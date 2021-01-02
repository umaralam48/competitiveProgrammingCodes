import java.util.PriorityQueue;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        PriorityQueue<TreeNode> minH = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        fillQueue(root, minH);
        root = minH.poll();
        TreeNode curr = root;
        while (!minH.isEmpty()) {
            curr.left = null;
            TreeNode temp = minH.poll();
            curr.right = temp;
            curr = temp;
        }
        curr.left = null;
        curr.right = null;
        return root;
    }

    private void fillQueue(TreeNode root, PriorityQueue<TreeNode> minH) {
        if (root == null)
            return;
        minH.add(root);
        fillQueue(root.left, minH);
        fillQueue(root.right, minH);
    }
}
