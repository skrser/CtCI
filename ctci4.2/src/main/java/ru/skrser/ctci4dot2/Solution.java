package ru.skrser.ctci4dot2;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Checks if two nodes in oriented graph are connected
     * Computation complexity = O(N), N - nodes in graph.
     * Memory consumption = O(1)
     *
     * @param node1 first node
     * @param node2 second node
     * @return true, if there is a way between nodes
     */
    public static boolean areConnected(Node node1, Node node2) {
        return findWay(node1, node2) || findWay(node2, node1);
    }

    private static boolean findWay(Node sourceNode, Node targetNode) {
        if (sourceNode == null || targetNode == null)
            return false;

        Set<Node> allReachableNodes = new HashSet<Node>();
        Set<Node> currentStepNodes;
        Set<Node> nextStepNodes = sourceNode.linkedNodes;
        while (!nextStepNodes.isEmpty()) {
            currentStepNodes = nextStepNodes;
            nextStepNodes = new HashSet<Node>();
            if (currentStepNodes.contains(targetNode))
                return true;
            for (Node linkedNode : currentStepNodes)
                nextStepNodes.addAll(linkedNode.linkedNodes);

            allReachableNodes.addAll(currentStepNodes);
            nextStepNodes.removeAll(allReachableNodes);
        }
        return false;
    }

}
