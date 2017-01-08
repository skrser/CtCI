package ru.skrser.ctci3dot2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int stackSize;
    private Node top;
    private List<Integer> minValues = new ArrayList<Integer>();

    public Solution() {
        stackSize = 0;
        minValues.set(0, null);
    }

    public void push(int data) {
        Node t = new Node(data);
        t.next = top;
        top = t;
        int minValue = data;
        stackSize++;
        if (stackSize > 1 && minValues.get(stackSize - 1) < data)
            minValue = minValues.get(stackSize - 1);
        minValues.set(stackSize, minValue);
    }

    public Integer min() {
        return minValues.get(stackSize);
    }

    public Integer pop() {
        if (top != null) {
            Node t = top;
            top = top.next;
            minValues.remove(stackSize--);
            return t.data;
        } else
            return null;
    }


}
