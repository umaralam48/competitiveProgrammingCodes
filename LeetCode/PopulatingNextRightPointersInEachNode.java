import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {

    }

    public Node connect(Node root) {

        List<Stack<Node>> list = new ArrayList<>();
        getSumByLevel(root, list, 0);
        return root;

    }

    private static void getSumByLevel(Node root, List<Stack<Node>> list, int level) {
        if (root == null)
            return;
        if (list.size() <= level) {
            list.add(new Stack<>());
        }
        Stack<Node> st = list.get(level);
        if (!st.isEmpty()) {
            Node prev = st.pop();
            prev.next = root;
        }
        st.add(root);
        getSumByLevel(root.left, list, level + 1);
        getSumByLevel(root.right, list, level + 1);
    }

}
