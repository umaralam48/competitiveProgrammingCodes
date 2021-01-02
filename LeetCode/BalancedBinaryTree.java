import jdk.nashorn.api.tree.Tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) == -1 ? false : true;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        if (hl == -1)
            return -1;
        int hr = height(root.right);
        if (hr == -1)
            return -1;
        if (Math.abs(hr - hl) > 1)
            return -1;
        return Math.max(hl, hr) + 1;
    }
}
