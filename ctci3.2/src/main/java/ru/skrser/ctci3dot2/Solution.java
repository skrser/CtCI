package ru.skrser.ctci3dot2;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack realisation with additional min() operation. push, pop, min operations run in constant time
 */
public class Solution {

    private Node top;
    private List<Integer> minValues = new ArrayList<Integer>();

    public Solution() {
        minValues.add(null);
    }

    public void push(int data) {
        Node t = new Node(data);
        t.next = top;
        top = t;
        int minValue = data;
        if (minValues.size() > 1 && minValues.get(minValues.size() - 1) < data)
            minValue = minValues.get(minValues.size() - 1);
        minValues.add(minValue);
    }

    public Integer min() {
        return minValues.get(minValues.size() - 1);
    }

    public Integer pop() {
        if (top != null) {
            Node t = top;
            top = top.next;
            minValues.remove(minValues.size() - 1);
            return t.data;
        } else
            return null;
    }


}
