import java.util.ArrayList;
import java.util.LinkedList;

public class MaxWidthOfBinaryTree {
    public static void main(String[] args) {
        Integer ar[] = { 1, 3, 2, 5, 3, null, 9 };
        TreeNode root = TreeNode.createTree(ar, 0);
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<ArrayList<Integer>> levels = new LinkedList<>();
        widthOfBinaryTree(root, levels, 0);
        int max = 0;
        for (ArrayList<Integer> level : levels) {
            int i = 0, j = level.size() - 1;

            while (i < level.size() && level.get(i) == null)
                i++;
            while (j >= 0 && level.get(j) == null)
                j--;
            int diff = j - i + 1;
            if (diff > 1)
                max = Math.max(max, diff);

        }
        return max;
    }

    private static void widthOfBinaryTree(TreeNode root, LinkedList<ArrayList<Integer>> levels, int level) {
        if (levels.size() <= level) {
            levels.add(new ArrayList<Integer>());
        }
        if (root == null && !levels.get(level).isEmpty()) {
            levels.get(level).add(null);
            widthOfBinaryTree(root, levels, level + 1);
            widthOfBinaryTree(root, levels, level + 1);

        } else if (root != null) {
            levels.get(level).add(root.val);
            widthOfBinaryTree(root.left, levels, level + 1);
            widthOfBinaryTree(root.right, levels, level + 1);
        }
    }
}