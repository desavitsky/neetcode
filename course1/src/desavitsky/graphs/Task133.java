package desavitsky.graphs;

import java.util.*;
import java.util.stream.Collectors;

// Clone Graph
public class Task133 {

    static class Node {
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

    Node cloneGraph(Node node) {
        if (node == null) return null;
        return clone(node, new HashMap<>());
    }

    Node clone(Node node, Map<Node, Node> nodesMapping) {
        var newNode = nodesMapping.get(node);
        if (newNode != null) return newNode;
        newNode = new Node(node.val);
        nodesMapping.put(node,newNode);
        newNode.neighbors = node.neighbors.stream().map(n ->clone(n, nodesMapping)).toList();
        return newNode;
    }
}
