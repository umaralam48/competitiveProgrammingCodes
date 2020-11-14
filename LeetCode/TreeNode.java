public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] ar) {
        return createTree(ar, 0);
    }

    private static TreeNode createTree(Integer[] ar, int i) {
        if (i >= ar.length || ar[i] == null)
            return null;
        TreeNode root = new TreeNode(ar[i]);
        root.left = createTree(ar, 2 * i + 1);
        root.right = createTree(ar, 2 * i + 2);
        return root;
    }
}