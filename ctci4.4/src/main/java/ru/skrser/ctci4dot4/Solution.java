package ru.skrser.ctci4dot4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**
     * Parses binary tree to list of linked lists. One linked list per tree level.
     * Computation complexity = O(N)
     * Memory consumption = O(log N) (for stack)
     *
     * @param root reference to tree root node
     * @return list of linked lists. List is empty if root is null. SubLists always contain at least one node.
     */
    public static List<List<Node>> getLists(Node root) {
        List<List<Node>> resultList = new ArrayList<List<Node>>();
        int level = 0;
        parseTree(root, level, resultList);
        return resultList;
    }

    private static void parseTree(Node root, int level, List<List<Node>> lists) {
        if (root == null)
            return;

        List<Node> list;
        if (lists.size() <= level) {
            list = new LinkedList<Node>();
            lists.add(list);
        } else
            list = lists.get(level);
        list.add(root);
        parseTree(root.left, level + 1, lists);
        parseTree(root.right, level + 1, lists);
    }

}
