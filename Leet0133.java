// https://leetcode.com/problems/clone-graph/submissions/
// https://leetcode.com/submissions/detail/763297328/
// Runtime: 38 ms, faster than 63.95% of Java online submissions for Clone Graph.
// Memory Usage: 43.6 MB, less than 34.77% of Java online submissions for Clone Graph.

import java.util.*;

public class Leet0133 {
    // Definition for a Node.
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



    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> alreadyCloned = new HashMap<>();
        if (node != null)
        {
            return clone(node, alreadyCloned);
        }
        else {
            return null;
        }
    }

    //
    public Node clone(Node node, HashMap<Integer, Node> alreadyCloned) {
        if (alreadyCloned.containsKey(node.val)) {
            return alreadyCloned.get(node.val);
        }

        Node copy = new Node(node.val);
        alreadyCloned.put(node.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, alreadyCloned));
        }
        return copy;
    }
}
