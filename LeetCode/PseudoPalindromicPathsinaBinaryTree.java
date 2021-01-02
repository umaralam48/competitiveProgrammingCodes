public class PseudoPalindromicPathsinaBinaryTree {
    public static void main(String[] args) {
        Integer[] a = { 9, 4, 7, 5, null, null, 9, null, null, 5, null, 8 };
        System.out.println(pseudoPalindromicPaths(TreeNode.createTree(a)));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, new int[10], 0);
    }

    private static int dfs(TreeNode root, int[] count, int oddn) {
        if (root == null)
            return 0;
        if (count[root.val] % 2 == 0)
            oddn++;
        else
            oddn--;
        count[root.val]++;
        if (root.left == null && root.right == null) {
            count[root.val]--;
            if (oddn == 1 || oddn == 0)
                return 1;
            else
                return 0;
        }
        int vl = dfs(root.left, count, oddn);
        int vr = dfs(root.right, count, oddn);
        count[root.val]--;
        return vl + vr;
    }
}
