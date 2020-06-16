public class PathSum {
    public static void main(String[] args) {
        System.out.println(mPathSum(createTree(null, 0), 5));
    }

    public static TreeNode createTree(int[] ar, int i) {
        if (i >= ar.length)
            return null;
        TreeNode root = new TreeNode(ar[i]);
        root.left = createTree(ar, 2 * i + 1);
        root.right = createTree(ar, 2 * i + 2);
        return root;
    }

    private static boolean mPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                return true;
            } else
                return false;
        } else
            return mPathSum(root.left, sum - root.val) || mPathSum(root.right, sum - root.val);
    }
}

class TreeNode {

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
}