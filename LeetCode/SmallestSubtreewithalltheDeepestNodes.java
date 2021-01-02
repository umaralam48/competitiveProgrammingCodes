public class SmallestSubtreewithalltheDeepestNodes {
    private static int max;
    private static TreeNode node;

    public static void main(String[] args) {
        Integer ar[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = TreeNode.createTree(ar);
        System.out.println(subtreeWithAllDeepest(root));
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        max = 0;
        subtreeWithAllDeepest(root, 0);
        return node;

    }

    private static int subtreeWithAllDeepest(TreeNode root, int depth) {
        if (root == null) {
            if (depth > max)
                max = depth;
            return depth;
        }
        int ld = subtreeWithAllDeepest(root.left, depth + 1);
        int rd = subtreeWithAllDeepest(root.right, depth + 1);
        if (ld == rd && ld >= max) {
            node = root;
            return ld;
        }
        return Math.max(ld, rd);
    }
}
