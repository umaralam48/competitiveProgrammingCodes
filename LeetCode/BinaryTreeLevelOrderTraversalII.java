import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        Integer[] ar = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = createTree(ar, 0);
        levelOrderBottom(root);
    }

    private static TreeNode createTree(Integer[] ar, int i) {
        if (i >= ar.length || ar[i] == null)
            return null;
        TreeNode root = new TreeNode(ar[i]);
        root.left = createTree(ar, 2 * i + 1);
        root.right = createTree(ar, 2 * i + 2);
        return root;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> sol = new LinkedList<>();
        sol.add(new ArrayList<Integer>());
        levelOrderBottom(root, 0, sol);
        return sol;
    }

    private static void levelOrderBottom(TreeNode root, int i, List<List<Integer>> sol) {
        if (root == null)
            return;
        if (i >= sol.size())
            sol.add(0, new ArrayList<Integer>());

        levelOrderBottom(root.left, i + 1, sol);
        levelOrderBottom(root.right, i + 1, sol);
        sol.get(sol.size() - 1 - i).add(root.val);
    }
}