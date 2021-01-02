public class ValidBinarySearchTree {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, Integer lesst, Integer gthan) {
        if (root == null)
            return true;
        if (lesst != null && root.val >= lesst)
            return false;
        if (gthan != null && root.val <= gthan)
            return false;
        else
            return isValidBST(root.left, root.val, gthan) && isValidBST(root.right, lesst, root.val);

    }
}
