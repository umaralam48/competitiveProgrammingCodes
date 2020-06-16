import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Works for any binary tree not necessarily BST
public class LowestCommonAncestor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        int n = y.nextInt();
        Integer nums1[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (y.hasNextInt()) {
                nums1[i] = y.nextInt();
            } else {
                y.next();
                nums1[i] = null;
            }
        }

        System.out.println(lowestCommonAncestor(createTree(nums1, 0), new TreeNode(2), new TreeNode(8)).val);
    }

    static int sum = 0;
    static TreeNode lca = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return lca;
        }
        int psum = sum;
        if (root.val == p.val || root.val == q.val)
            sum++;
        if (sum != 2) {
            lowestCommonAncestor(root.left, p, q);
            lowestCommonAncestor(root.right, p, q);
        }
        if (psum == 0 && sum == 2 && lca == null) {
            lca = root;
            return lca;
        }

        return lca;
    }

    public static TreeNode createTree(Integer[] ar, int i) {
        if (i >= ar.length)
            return null;
        if (ar[i] == null) {
            return null;
        }
        TreeNode root = new TreeNode(ar[i]);
        root.left = createTree(ar, 2 * i + 1);
        root.right = createTree(ar, 2 * i + 2);
        return root;
    }
}