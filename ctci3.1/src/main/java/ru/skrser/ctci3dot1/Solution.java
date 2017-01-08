package ru.skrser.ctci3dot1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final int STACKS_NUMBER = 3;

    private int[] stackIndex = new int[STACKS_NUMBER];
    private List<Integer> arrayList = new ArrayList<Integer>();

    public void push(int stackNum, int data) {
        checkStackNum(stackNum);
        arrayList.add(stackIndex[stackNum]++ * STACKS_NUMBER, data);
    }

    private void checkStackNum(int stackNum) {
        if (stackNum < 0 || stackNum > STACKS_NUMBER - 1)
            throw new IllegalArgumentException("Illegal value for stackNum: " + stackNum + ". Should be 0.." + (STACKS_NUMBER - 1));
    }

    public Integer pop(int stackNum) {
        checkStackNum(stackNum);
        int dataIndex = --stackIndex[stackNum] * STACKS_NUMBER;
        if (dataIndex >= 0) {
            int data = arrayList.get(dataIndex);
            arrayList.set(dataIndex, null);
            return data;
        } else {
            stackIndex[stackNum] = 0;
            return null;
        }
    }

    public Integer pick(int stackNum) {
        checkStackNum(stackNum);
        int dataIndex = (stackIndex[stackNum] - 1) * STACKS_NUMBER;
        if (dataIndex >= 0) {
            return arrayList.get(dataIndex);
        } else {
            return null;
        }
    }


}
