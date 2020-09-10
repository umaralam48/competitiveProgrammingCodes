public class PathSum3 {
    public static void main(String[] args) {
        Integer[] a = { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 };
        TreeNode root = TreeNode.createTree(a);
        System.out.println(pathSum(root, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        return 0;
    }
}