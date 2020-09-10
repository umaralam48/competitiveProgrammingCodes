public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Integer[] a = { 1, 0, 1, 0, 1, 0, 1 };
        TreeNode root = TreeNode.createTree(a);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        return sumRootToLeaf(root, 0);
    }

    private static int sumRootToLeaf(TreeNode root, int pathsum) {

        pathsum = (pathsum << 1) + root.val;
        if (root.left == null && root.right == null)
            return pathsum;
        else if (root.left == null)
            return sumRootToLeaf(root.right, pathsum);
        else if (root.right == null)
            return sumRootToLeaf(root.left, pathsum);
        else
            return sumRootToLeaf(root.left, pathsum) + sumRootToLeaf(root.right, pathsum);
    }

}
