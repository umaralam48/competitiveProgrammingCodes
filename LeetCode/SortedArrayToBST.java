public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] ar = {};
        System.out.println(-1 / 2);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] ar, int i, int j) {
        if (i > j)
            return null;
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(ar[mid]);
        root.left = sortedArrayToBST(ar, i, mid - 1);
        root.right = sortedArrayToBST(ar, mid + 1, j);
        return root;
    }
}
