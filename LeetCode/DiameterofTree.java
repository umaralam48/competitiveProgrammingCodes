import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DiameterofTree {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.nextInt();
        }

        System.out.println(diameterOfBinaryTree(createTree(nums1, 0)));
        System.out.println(max);
    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        height(root);
        return max;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int height = Math.max(lh, rh) + 1;
        max = Math.max(lh + rh, max);
        return height;
    }

    public static TreeNode createTree(int[] ar, int i) {
        if (i >= ar.length)
            return null;
        TreeNode root = new TreeNode(ar[i]);
        root.left = createTree(ar, 2 * i + 1);
        root.right = createTree(ar, 2 * i + 2);
        return root;
    }
}