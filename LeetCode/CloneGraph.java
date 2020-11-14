import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// Definition for a Node.

class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Integer, Node> map;

    public Node CloneGraph(Node node) {
        Set<Integer> visited = new HashSet<>();
        map = new HashMap<>();
        return cloneNode(node, visited);
    }

    private Node cloneNode(Node node, Set<Integer> visited) {
        if (node == null)
            return null;
        Node ccn = new Node();
        ccn.val = node.val;
        visited.add(ccn.val);
        map.put(ccn.val, ccn);
        for (Node n : node.neighbors) {
            if (visited.contains(n.val)) {
                ccn.neighbors.add(map.get(n.val));
                continue;
            }
            ccn.neighbors.add(cloneNode(n, visited));
        }
        return ccn;
    }
}