import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class FindRightInterval {

    public static void main(String[] args) {
        int[][] a = { { 1, 4 }, { 2, 3 }, { 3, 4 } };
        System.out.println(Arrays.toString(findRightInterval(a)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        TreeSet<Inode> tree = new TreeSet<Inode>(new Comparator<Inode>() {
            public int compare(Inode a, Inode b) {
                return a.lo - b.lo;
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            tree.add(new Inode(intervals[i], i));
        }
        for (int i = 0; i < ans.length; i++) {
            Inode ceil = (tree.ceiling(new Inode(new int[] { intervals[i][1] }, -1)));
            ans[i] = ceil == null ? -1 : ceil.index;
        }
        return ans;

    }
}

class Inode {
    public int index;
    public int lo;

    public Inode(int[] interval, int index) {
        this.lo = interval[0];
        this.index = index;
    }
}
/*
 * class INode { public int index; public INode left; public INode right; int
 * lo, hi;
 * 
 * public INode(int[] interval, int index) { this.lo = interval[0]; this.hi =
 * interval[1]; this.index = index; }
 * 
 * public static INode add(INode root, int[] interval, int i) { if (root ==
 * null) return new INode(interval, i); if (interval[0] < root.lo) { root.left =
 * add(root.left, interval, i); } else { root.right = add(root.right, interval,
 * i); } return root; }
 * 
 * public static int searchEnd(INode root, int[] interval) { if (root == null)
 * return -1; if (root.lo >= interval[1]) { if (root.left == null) return
 * root.index; else { int index = searchEnd(root.left, interval); return index
 * == -1 ? root.index : index; } } else { return searchEnd(root.right,
 * interval); } } }
 */